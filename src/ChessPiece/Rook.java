package ChessPiece;

import ChessBoard.Board;
import ChessBoard.BoardCell;
import ChessCommon.Colour;
import ChessCommon.GameRules;
import ChessCommon.ProcessMove;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class Rook extends Piece
{
    public Rook(Colour colour)
    {
        super(colour);
    }
    /**
     * Checks if rook does not attack its own colour
     * checks if it only moves up down or left right
     * checks if the path in between is clear so it wont jump over pieces
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
        
        if(x1 != 0 && y1 != 0)
        {
            return -1;
        }
        
        return rules.isMovePathClear(); //to process movePathClear
    }
     
    @Override
    public String toString() 
    {
        if(this.getColour() == Colour.Black)
        {
            return "Black Rook";
        }
        else
        {
            return "White Rook";
        }
    }
    
}
