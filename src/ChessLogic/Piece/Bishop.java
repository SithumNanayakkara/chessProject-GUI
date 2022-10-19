package ChessLogic.Piece;

import ChessLogic.Board.Board;
import ChessLogic.Board.BoardCell;
import ChessLogic.Common.Colour;
import ChessLogic.Common.GameRules;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class Bishop extends Piece
{
     public Bishop(Colour colour)
    {
        super(colour);
    }
     /**
      * Checks if bishop does not attack its own colour
      * checks if bishop only moves in diagonal blocks; x1 distance is not equal to y1
      * @param board
      * @param initialPos
      * @param finalPos
      * @return 
      */
    
    @Override
    public int allowedMove(Board board, BoardCell initialPos, BoardCell finalPos) 
    {
         GameRules rules = new GameRules(board,initialPos.getXLocation(), initialPos.getYLocation(), finalPos.getXLocation(), finalPos.getYLocation());
        
        if (finalPos.getPiece() != null && finalPos.getPiece().getColour() == this.getColour())
        {
            return -1;
        }
        
        int x1 = Math.abs(initialPos.getXLocation()-finalPos.getXLocation());
        int y1 = Math.abs(initialPos.getYLocation()-finalPos.getYLocation());
        
        if(x1 != y1)
        {
            return -1;
        }
        
        return rules.isMovePathClear();
        
    }

    @Override
    public String toString() 
    {
        if(this.getColour() == Colour.Black)
        {
            return "♝";
        }
        else
        {
            return "♗";
        }
    }
}
