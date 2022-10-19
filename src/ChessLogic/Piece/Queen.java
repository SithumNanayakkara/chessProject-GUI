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
public class Queen extends Piece
{
    public Queen(Colour colour)
    {
        super(colour);
    }
    /**
     * Checks if the queen is attacking its own colored piece
     * checks if logic similar to rook
     *  or logic similar to bishop
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
        
        if(x1 != 0 && y1 == 0 || x1 == 0 && y1 != 0)
        {
            return rules.isMovePathClear();
        }
        
        if(x1 == y1)
        {
            return rules.isMovePathClear();
        }
        
        return -1;
    }
    @Override
    public String toString() 
    {
        if(this.getColour() == Colour.Black)
        {
            return "♛";
        }
        else
        {
            return "♕";
        }
    }
}
