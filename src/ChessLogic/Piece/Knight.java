/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessLogic.Piece;

import ChessLogic.Board.Board;
import ChessLogic.Board.BoardCell;
import ChessLogic.Common.Colour;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class Knight extends Piece
{
   
    public Knight(Colour colour)
    {
        super(colour);
        
    }

    /**
     * checks if knight don't attack its own
     * checks if the diagonal distance is always 2
     * @param board
     * @param initialPos
     * @param finalPos
     * @return 
     */
    @Override
    public int allowedMove(Board board, BoardCell initialPos, BoardCell finalPos) 
    {
        if (finalPos.getPiece() != null && finalPos.getPiece().getColour() == this.getColour())
        {
            return -1;
        }
        
        int x1 = Math.abs(initialPos.getXLocation()-finalPos.getXLocation());
        int y1 = Math.abs(initialPos.getYLocation()-finalPos.getYLocation());
        
        if(x1*y1 == 2)
            return 1;
        else 
            return -1;
        
       
    }
    
    @Override
    public String toString() 
    {
        if(this.getColour() == Colour.Black)
        {
            return "Black Knight";
        }
        else
        {
            return "White Knight";
        }
    }
    
}
