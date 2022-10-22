package ChessLogic.Common;

import ChessLogic.Piece.King;
import ChessLogic.Board.Board;
import ChessLogic.Piece.Piece;
import java.util.Scanner;
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
    private String userMove;
    private final Board board;
    private final Scanner scan;
    private List<String> movesPlayed;
    
    private Piece initialPiece, finalPiece;
    private String initalCoordinate, finalCoordinate;
    private int turn, initialRank, initialFile,finalRank, finalFile;
    
    
    
    public ProcessMove() 
    {
        this.turn = 0;
        this.finalFile = 0;
        this.finalRank = 0;
        this.initialRank = 0;
        this.initialFile = 0;
        
        this.userMove = "";
        
        this.initialPiece = null;
        this.finalPiece = null;
        
        board = new Board ();
        scan = new Scanner (System.in);
        movesPlayed = new ArrayList <String>();
        setColour();
        showWhoMoves();
    }
    /**
     * Checks if the game is in a winning point (any checkmates)
     * gets the user to input the desired move
     * @return 
     */
    public void showWhoMoves()
    {
        System.out.printf("\nIt is %s's turn ", colour == Colour.Black ? "Black" : "White");
        System.out.print("\nYour Input: ");
    }
    
    /**
     * sets the colour for the correct turn
     * @return 
     */
    
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
        initialPiece = move.getInitialC().getPiece();
        finalPiece = move.getFinalC().getPiece();
        
        if(this.initialPiece == null) //if coordinates are null
        {
            System.out.println("\nAlert: Initial Coordinate contains no piece, please try again!");
            return -1;
        }
        
        if(this.initialPiece.getColour()!= this.colour) //if opponents pices are moved
        {
            System.out.println("\nAlert: You are not allowed to move enemies pieces, please try again!");
            return -1;
        }
        if(this.initialPiece.allowedMove(this.board,move.getInitialC(), move.getFinalC()) == -1) //if illegal move
        {
            System.out.println("\nAlert: " +move.getInitialC().toString() + " cannot move like that, please try again!");
            return -1;
        }
        if (this.initialPiece.allowedMove(this.board,move.getInitialC(), move.getFinalC()) == -2) //if king is getting checked
        {
            System.out.println("\nAlert: " +move.getInitialC().toString() + " is getting checked by " + this.checkKing.getCheckBy().toString() + ", please try again!");
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
            //System.out.println(this.finalPiece.toString()+" at \""+ this.finalCoordinate.toUpperCase() +"\" is Killed!");
        }
        
        move.getInitialC().getPiece().setIsInitialMove(false);
        move.getFinalC().setPiece(move.getInitialC().getPiece());
        move.getInitialC().setPiece(null);
        
        //sotres the moves to show logs later on
        movesPlayed.add((turn+1)+" "+this.initalCoordinate + " " +this.initialPiece.toString() + " to " + this.finalCoordinate );
        
        
        this.turn++;
        setColour();
        showWhoMoves();
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
            
            System.out.println("Pieces "+ move.getFinalC().toString()+" and " + moveCastling.getFinalC().toString() + " castled!");

            move.getFinalC().setPiece(move.getInitialC().getPiece());
            move.getInitialC().setPiece(null);

            moveCastling.getFinalC().setPiece(moveCastling.getInitialC().getPiece());
            moveCastling.getInitialC().setPiece(null);
            
            this.turn++;
            setColour();
            showWhoMoves();
        }
        if(initialFile+finalFile == 10) //castling on the right
        {
            BoardCell newInitialCell = this.board.getCell(initialRank,initialFile+3);
            BoardCell newFinalCell = this.board.getCell(finalRank, finalFile-1);
            Move moveCastling = new Move(newInitialCell,newFinalCell);
            
            System.out.println("Pieces "+ move.getInitialC().toString()+" and " + moveCastling.getInitialC().toString() + " castled!");
            
            move.getFinalC().setPiece(move.getInitialC().getPiece());
            move.getInitialC().setPiece(null);

            moveCastling.getFinalC().setPiece(moveCastling.getInitialC().getPiece());
            moveCastling.getInitialC().setPiece(null);
            
            this.turn++;
            setColour();
            showWhoMoves();
        }
    }
    
    /**
     * Processes whether the king is checked
     * @param move
     * @return 
     */
    public boolean isKingChecked(Move move)
    {
        if(initialPiece.getColour() == Colour.White)
        {
            
            this.checkKing = new King(Colour.White);
            
            move.getFinalC().setPiece(move.getInitialC().getPiece()); //adding piece temporarily
            move.getInitialC().setPiece(null);//remove the orignial piece temporily
            
            if(checkKing.alreadyCheck(board))        
            {
                move.getInitialC().setPiece(move.getFinalC().getPiece()); //add back the original piece
                move.getFinalC().setPiece(null); //removing temp piece
                
                System.out.println("\nAlert: " + checkKing.toString() + " in check by " + this.checkKing.getCheckBy().getPiece().toString() + " requires attention!\nPlease try again!");
                return true;
            }
            
            move.getInitialC().setPiece(move.getFinalC().getPiece()); //add back the original piece
            move.getFinalC().setPiece(null); //removing temp piece
        }
        else
        {
            this.checkKing = new King(Colour.Black);
            
            move.getFinalC().setPiece(move.getInitialC().getPiece()); //adding piece temporarily
            move.getInitialC().setPiece(null);//remove the orignial piece temporily

            if(checkKing.alreadyCheck(board))        
            {
                move.getInitialC().setPiece(move.getFinalC().getPiece()); //add back the original piece
                move.getFinalC().setPiece(null); //removing temp piece
                
                System.out.println("\nAlert: " + checkKing.toString() + " in check by " + this.checkKing.getCheckBy().getPiece().toString() + " requires attention!\nPlease try again!");
                return true;
            }
            move.getInitialC().setPiece(move.getFinalC().getPiece()); //add back the original piece
            move.getFinalC().setPiece(null); //removing temp piece
        }
        return false;
    }
    //displays the log files one line at a time
    public void displayMoves()
    {
        for(String moves: this.movesPlayed)
        {
            System.out.println(moves);
        }
    }
    //checks which colour is moving 
    public boolean isWhite ()
    {
        return this.turn % 2 == 0;
    } 
    
}
   