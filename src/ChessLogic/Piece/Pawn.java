/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessLogic.Piece;

import ChessLogic.Board.Board;
import ChessLogic.Board.BoardCell;
import ChessLogic.Common.Colour;
import ChessLogic.Common.GameRules;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class Pawn extends Piece
{
   
    
    public Pawn(Colour colour)
    {
        super(colour);
    }
    
    /**
     * checks if the pawn is not attacking its own colored piece
     * checks if the pawn is only moving forwards and not backwards
     * checks if the pawn is in its initial move, if so  it is allowed to move two cells forward
     * if the pawn is not in its initial move it only can move once
     * pawn is allowed to move diagonal once only to kill pieces
     * @param board
     * @param initialPos
     * @param finalPos
     * @return 
     */
    
    @Override
    public int allowedMove(Board board, BoardCell initialPos, BoardCell finalPos) 
    {
        GameRules rules = new GameRules(board,initialPos.getXLocation(), initialPos.getYLocation(), finalPos.getXLocation(), finalPos.getYLocation());
        
        int x1 = Math.abs(initialPos.getXLocation()-finalPos.getXLocation());
        int y1 = Math.abs(initialPos.getYLocation()-finalPos.getYLocation());
        
        if (finalPos.getPiece() != null && finalPos.getPiece().getColour() == this.getColour())
        {
            return -1;
        }
        
        if(this.getColour() == Colour.Black)
        {
            if(initialPos.getXLocation() > finalPos.getXLocation())
            {
                return -1;
            }
        }
        else 
        {
            if(initialPos.getXLocation() < finalPos.getXLocation())
            {
                return -1;
            }
        }
        
        
        //if moving 2 squares initially
        if(this.isIsInitialMove()&& x1 == 2 && y1 ==0 && finalPos.getPiece() == null )
        {
            return rules.isMovePathClear();
        }
        //moving 1 sqaure
        if(x1 == 1 && y1 ==0 && finalPos.getPiece() == null)
        {
            return 1;
        }
        //moving diagonal to kill
        if(x1 == 1 && y1 ==1 && finalPos.getPiece() != null && finalPos.getPiece().getColour() != this.getColour())
        {
            return 1;
        }
        
        return -1;
    }

    @Override
    public String toString() 
    {
        if(this.getColour() == Colour.Black)
        {
            return "♟";
        }
        else
        {
            return "♙";
        }
    }
}
