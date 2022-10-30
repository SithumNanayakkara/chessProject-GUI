package ChessLogic.Common;

import ChessLogic.Piece.King;
import ChessLogic.Board.Board;
import ChessLogic.Piece.Piece;
import ChessLogic.Board.BoardCell;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */

public class ProcessMove
{
    private King checkKing;
    private Colour colour;
    private Piece initialPiece, finalPiece;
    private final Board board;
    private int turn, initialRank, initialFile,finalRank, finalFile;
    private String invalidMove;
    
    public ProcessMove () 
    {
        this.turn = 0;
        this.finalFile = 0;
        this.finalRank = 0;
        this.initialRank = 0;
        this.initialFile = 0;
        this.initialPiece = null;
        this.finalPiece = null;
        this.invalidMove = "";
        board = new Board ();
    }
    /**
     * Checks if the game is in a winning point (any checkmates)
     * gets the user to input the desired move
     * @return 
     */
    public String showWhoMoves()
    {
        System.out.printf("\nIt is %s's turn ", colour == Colour.Black ? "Black" : "White");
        System.out.print("\nYour Input: ");
        return this.colour.toString();
    }
    
    /**
     * sets the color for the correct turn
     * @return 
     */
    
    public void setTurn(int turn)
    {
        this.turn = turn;
    }
    
    public int getTurn()
    {
        return this.turn;
    }
    
    public void setColour()
    {
        if(this.isWhite())
        {
            this.colour = Colour.White;
        }
        else
        {
            this.colour = Colour.Black;
        }
    }
    
    public String getColour()
    {
        return this.colour.toString();
    }
    
    public String getInvalidMove()
    {
        return invalidMove;
    }
    
    public boolean winningCondition ()
    {
        checkKing = new King(this.colour);
        return checkKing.isCheckMate(board);
    }
    /**
     *  @return 
     *  It initializes the BoardCell class with the rank and file coordinate system from the earlier method
     *  This creates one object with the initial and final Rank and File values eg. (x1,y1) (x2,y2)
     *  Then, it creates a move object which puts together the coordinates of the initial and final position of one move
     *  Lastly, it calls the doMove method in its return with the move parameter.
     */
    public int getMoveCells(int initialRank, int initialFile, int finalRank, int finalFile)
    {
        this.finalFile = finalFile;
        this.finalRank = finalRank;
        this.initialRank = initialRank;
        this.initialFile = initialFile;
        
        BoardCell initialCell = this.board.getCell(initialRank,initialFile);
        BoardCell finalCell = this.board.getCell(finalRank, finalFile);

        Move move = new Move(initialCell,finalCell);

        return doMove(move);
    }
    
    /**
     *  @param move
     *  @return 
     *  
     */
    public int doMove (Move move)
    {
        this.invalidMove = "";
        initialPiece = move.getInitialC().getPiece();
        finalPiece = move.getFinalC().getPiece();
        
        if(this.initialPiece == null) //if coordinates are null
        {
            this.invalidMove = "Alert: Initial click contains no piece!";
            System.out.println("\n" + invalidMove);
            return -1;
        }
        
        if(this.initialPiece.getColour()!= this.colour) //if opponents pices are moved
        {
            this.invalidMove = "Alert: Can't move enemies pieces!";
            System.out.println("\n" + invalidMove);
            return -1;
        }
        if(this.initialPiece.allowedMove(this.board,move.getInitialC(), move.getFinalC()) == -1) //if illegal move
        {
            this.invalidMove = "Alert: " +move.getInitialC().toString() + " can't move like that!";
            System.out.println("\n" + invalidMove);
            return -1;
        }
        if (this.initialPiece.allowedMove(this.board,move.getInitialC(), move.getFinalC()) == -2) //if king is getting checked
        {
            this.invalidMove = ("Alert: " + move.getInitialC().toString() + " is getting checked by " + this.checkKing.getCheckBy() + "!");
            System.out.println("\n"+ invalidMove);
            return -1;   
        }
        if (this.initialPiece.allowedMove(this.board,move.getInitialC(), move.getFinalC()) == 2)  //if king is castling
        {
            this.processCastling(move);
            return 0;
        }
        if(isKingChecked(move))
        {
            return -1;
        }
        if(this.finalPiece != null) //killing
        {
            this.finalPiece.setPeiceStatus(true);
            move.setKilledPiece(this.finalPiece);
            this.invalidMove = (this.finalPiece.toString()+" got "+ " Killed!");
            System.out.println(invalidMove);
        }
        
        move.getInitialC().getPiece().setIsInitialMove(false);
        move.getFinalC().setPiece(move.getInitialC().getPiece());
        move.getInitialC().setPiece(null);
        
        //sotres the moves to show logs later on
        //movesPlayed.add((turn+1)+" "+this.initalCoordinate + " " +this.initialPiece.toString() + " to " + this.finalCoordinate );
        
        this.turn++;
        setColour();
        return 0;
    }
    
    /**
     * if castling is done, it will be processed here
     * for the castling in the left hand side of the board the files add  up to 6
     * for castling done on the right hand side of the board the files add up to 10
     * @param move 
     */
    
    public void processCastling(Move move)
    {
        if(this.initialFile+this.finalFile == 6) //casling on the left (long castling)
        {
            BoardCell newInitialCell = this.board.getCell(initialRank,initialFile-4);
            BoardCell newFinalCell = this.board.getCell(finalRank, finalFile+1);
            Move moveCastling = new Move(newInitialCell,newFinalCell);

            move.getFinalC().setPiece(move.getInitialC().getPiece());
            move.getInitialC().setPiece(null);

            moveCastling.getFinalC().setPiece(moveCastling.getInitialC().getPiece());
            moveCastling.getInitialC().setPiece(null);
            
            
            
            this.invalidMove = ("Pieces "+ move.getFinalC().toString()+" and " + moveCastling.getFinalC().toString() + " castled!");
            System.out.println(invalidMove);
            
            this.turn++;
            setColour();
        }
        if(initialFile+finalFile == 10) //castling on the right
        {
            BoardCell newInitialCell = this.board.getCell(initialRank,initialFile+3);
            BoardCell newFinalCell = this.board.getCell(finalRank, finalFile-1);
            Move moveCastling = new Move(newInitialCell,newFinalCell);
            
            
            move.getFinalC().setPiece(move.getInitialC().getPiece());
            move.getInitialC().setPiece(null);

            moveCastling.getFinalC().setPiece(moveCastling.getInitialC().getPiece());
            moveCastling.getInitialC().setPiece(null);
            
            
            this.invalidMove = ("Pieces "+ move.getFinalC().toString()+" and " + moveCastling.getFinalC().toString() + " castled!");
            System.out.println(invalidMove);
            
            this.turn++;
            setColour();
        }
    }
    
    /**
     * Processes whether the king is checked
     * @param move
     * @return 
     */
    public boolean isKingChecked(Move move)
    {
        Piece tempPiece = move.getFinalC().getPiece();
        if(initialPiece.getColour() == Colour.White)
        {
            
            this.checkKing = new King(Colour.White);
            
            move.getFinalC().setPiece(move.getInitialC().getPiece()); //adding piece temporarily
            move.getInitialC().setPiece(null);//remove the orignial piece temporily
            
            if(checkKing.alreadyCheck(board))        
            {
                move.getInitialC().setPiece(move.getFinalC().getPiece()); //add back the original piece
                move.getFinalC().setPiece(tempPiece); //removing temp piece
                
                this.invalidMove = ("Alert: " + checkKing.toString() + " in check by " + this.checkKing.getCheckBy() + " requires attention!");
                System.out.println(invalidMove);
                return true;
            }
            
            move.getInitialC().setPiece(move.getFinalC().getPiece()); //add back the original piece
            move.getFinalC().setPiece(tempPiece); //removing temp piece
        }
        else
        {
            this.checkKing = new King(Colour.Black);
            
            move.getFinalC().setPiece(move.getInitialC().getPiece()); //adding piece temporarily
            move.getInitialC().setPiece(null);//remove the orignial piece temporily

            if(checkKing.alreadyCheck(board))        
            {
                move.getInitialC().setPiece(move.getFinalC().getPiece()); //add back the original piece
                move.getFinalC().setPiece(tempPiece); //removing temp piece
                
                this.invalidMove = ("Alert: " + checkKing.toString() + " in check by " + this.checkKing.getCheckBy() + " requires attention!");
                System.out.println(invalidMove);
                return true;
            }
            move.getInitialC().setPiece(move.getFinalC().getPiece()); //add back the original piece
            move.getFinalC().setPiece(tempPiece); //removing temp piece
        }
        return false; 
    }
    
    //checks which colour is moving 
    public boolean isWhite ()
    {
        return this.turn % 2 == 0;
    } 
    
}
   