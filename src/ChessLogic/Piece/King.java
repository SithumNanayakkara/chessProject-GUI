/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessLogic.Piece;

import ChessLogic.Board.Board;
import ChessLogic.Board.BoardCell;
import ChessLogic.Common.Colour;
import ChessLogic.Common.GameRules;
import ChessLogic.Common.Move;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class King extends Piece
{
    private Board board;
    private BoardCell checkBy;
    private Piece checkPiece;
    
    public King(Colour colour)
    {
        super(colour);
    }
    
    /**
     * Checks if king is attacking its own colour
     * Checks if the move will cause the king to go check
     * Checks if king is trying to do castling move if both rook and king is in its initial move
     * Checks if king is going only up, down or left right like a rook
     * Checks if king is going to the sides like a bishop
     * @param board
     * @param initialPos
     * @param finalPos
     * @return 
     */
    
    @Override
    public int allowedMove(Board board, BoardCell initialPos, BoardCell finalPos) 
    {
        this.board = board;
        
        int x1 = Math.abs(initialPos.getXLocation()-finalPos.getXLocation());
        int y1 = Math.abs(initialPos.getYLocation()-finalPos.getYLocation());
        
       
        if (finalPos.getPiece() != null && finalPos.getPiece().getColour() == this.getColour()) //if attacking same colour
        {
            return -1;
        }
        if(this.isCheck(initialPos, finalPos, board)) //if in check
        {
            return -2;
        }
        
        Rook rook = new Rook (this.getColour());
        GameRules rules = new GameRules(board,initialPos.getXLocation(), initialPos.getYLocation(), finalPos.getXLocation(), finalPos.getYLocation());
        
        //Castling
        if(this.isIsInitialMove() && rook.isIsInitialMove() && (finalPos.getYLocation()== initialPos.getYLocation()+2 || finalPos.getYLocation()== initialPos.getYLocation()-2))
        {
            if(rules.isMovePathClear() == 0)
            {
                return 2;
            }
        }
        else if(x1 == 1 && y1 == 1)
        {
            return 1;
        }
        else if(x1 + y1 == 1)
        {
            return 1;
        }
        return -1;
    }
    
    /**
     * Creates a move object which holds the initial and final positions
     * A hypothetical scenario is checked with the entered coordinates
     * Checks whether move done is causing the king to be checked
     * @param initialPos
     * @param finalPos
     * @param board
     * @return 
     */
    public boolean isCheck (BoardCell initialPos, BoardCell finalPos,Board board)
    {
        Move move = new Move(initialPos, finalPos);
        Piece tempPiece = move.getFinalC().getPiece();
        
        move.getFinalC().setPiece(move.getInitialC().getPiece()); //adding piece temporarily
        move.getInitialC().setPiece(null);//remove the orignial piece temporily
        
        for(BoardCell[] cells : board.getCells())
        {
            for(BoardCell cell : cells)
            {    
                if(cell.getPiece() != null && !(cell.getPiece() instanceof King) && cell.getPiece() != this && cell.getPiece().getColour() != this.getColour() && cell.getPiece().allowedMove(board, cell, finalPos) != -1)
                {
                    
                    move.getInitialC().setPiece(move.getFinalC().getPiece()); //add back the original piece
                    move.getFinalC().setPiece(null); //removing temp piece
                    return true;
                }
            }
        }
        move.getInitialC().setPiece(move.getFinalC().getPiece()); //add back the original piece
        move.getFinalC().setPiece(null); //removing temp piece
         
        return false;
    }
    
    /**
     * Finds where the King is in the board and gets its coordinates by iterating through each cell in the array
     * @param board
     * @return 
     */
    
    public BoardCell kingLocation(Board board)
    {
        for(BoardCell[] cells : board.getCells())
        {
            for(BoardCell cell : cells)
            {  
                
                if(cell.getPiece() != null && cell.getPiece().toString().equals(this.toString()))
                {
                    return board.getCell(cell.getXLocation(), cell.getYLocation());
                }
               
            }
        }
        return null;
    }
    
    /**
     * Checks if the previous (enemy) move caused the kind to be checked
     * @param board
     * @return 
     */
    
    public boolean alreadyCheck (Board board)
    {
        BoardCell kingLocation = kingLocation(board);
        for(BoardCell[] cells : board.getCells())
        {
            for(BoardCell cell : cells)
            {  
                 if(cell.getPiece() != null && !(cell.getPiece() instanceof King) && cell.getPiece() 
                        != this && cell.getPiece().getColour() != this.getColour() && cell.getPiece().allowedMove(board, cell, kingLocation) != -1)
                {
                    this.checkBy = cell;
                    this.checkPiece = cell.getPiece();
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Checks if the king got checkmated
     * @param board
     * @return  
     */
    public boolean isCheckMate (Board board)
    {
        if(this.alreadyCheck(board))
        {
            GameRules rules = new GameRules(board,this.checkBy.getXLocation(), this.checkBy.getYLocation(), this.kingLocation(board).getXLocation(), this.kingLocation(board).getYLocation());
            if(rules.canBlockPath()==1)
            {
                return false;
            }
            
            for(BoardCell[] cells : board.getCells())
            {
                for(BoardCell cell : cells)
                {
                    
                    //check if king can kill the check piece
                    if(cell.getPiece() != null && cell.getPiece().allowedMove(board, kingLocation(board), cell) != -1)
                    {
                        return false;
                    }
                    //cehck if other pieces can 
                    else if(cell.getPiece() != null && !(cell.getPiece() instanceof King) && cell.getPiece().allowedMove(board, cell, this.checkBy) != -1)
                    {
                        return false;
                    }   
                     
                }
            }
            
            System.out.println("\n        "+this.checkPiece+ " Checkmated " + this.toString());
            System.out.println("           "+this.checkPiece.getColour() + " Wins!");
            return true;
        }               
        
        return false;
    }

    public String getCheckBy() 
    {
        return this.checkPiece.toString();
    }
    
   

    @Override
    public String toString() 
    {
        if(this.getColour() == Colour.Black)
        {
            return "Black King";
        }
        else
        {
            return "White King";
        }
    }
    
}
