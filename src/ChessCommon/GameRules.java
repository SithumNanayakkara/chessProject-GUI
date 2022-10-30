/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessCommon;

import ChessBoard.Board;
import ChessBoard.BoardCell;
import ChessPiece.King;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class GameRules 
{
    //TODO en passant
    //TODO stalemate
    //TODO pawn promotion
    
    private final Board board ;
    private int pathLength;
    private int xDirection;
    private int yDirection ;
    private int x1, y1, x2, y2;

    public GameRules(Board board, int x1, int y1, int x2, int y2) {
        this.board = board;
        this.pathLength = 0;
        this.xDirection = 0;
        this.yDirection = 0;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.movePath();
    }
    
    /**
     * 
     * Checks if the piece is traveling up, down or left right and gets the distance between the move
     */
    public void movePath ()
    {
        int xDistance = this.x2-this.x1;//finalRank - initialRank;
        int yDistance = this.y2-this.y1;//finalFile - initialFile;
        
        if (xDistance > 0)
        {
            this.xDirection = 1; //going to the right
        }
        else if (xDistance <0)
        {
            this.xDirection = -1; //going to the left
        }
        
        if (yDistance > 0)
        {
            this.yDirection = 1; //going up
        }
        else if (yDistance <0)
        {
            this.yDirection = -1; //going down
        }
        
        if(yDistance != 0)
        {
            this.pathLength = Math.abs(yDistance)-1; //length is distance -1 to ignore final cell
        }
        else
        {
            this.pathLength = Math.abs(xDistance)-1;
        }
    }
    
    /**
     * Checks if the path between a move is clear
     * @return 
     */
    public int isMovePathClear ()
    {
        for (int i=0; i<this.pathLength; i++)
        {
            this.x1 += this.xDirection;
            this.y1 += this.yDirection;
            
            if( this.board.getCell(this.x1,this.y1).getPiece() != null)
            {
                return -1;
            }
        }
        return 0;
    }
    
    /**
     * if the path length is more than 1
     * checks if any other piece has any legal moves to enter the path between a move done
     * this is used to check if checkmate can be prevented if a piece enters the path in between the piece causing the check
     * @return 
     */
    public int canBlockPath ()
    {
        for (int i=0; i<this.pathLength; i++)
        {
            this.x1 += this.xDirection;
            this.y1 += this.yDirection;
            
            if(this.pathLength == 1)
            {
                return 0;
            }
            
            for(BoardCell[] cells : board.getCells())
            {
                for(BoardCell cell : cells)
                { 
                    if(cell.getPiece() != null  && (cell.getPiece().allowedMove(board,cell,board.getCell(x1,y1))==1 || cell.getPiece().allowedMove(board,cell,board.getCell(x1,y1))==2))
                    {
                        return 1;
                    }
                }
            }
            
        }
        return 0;
    }
    
    
    
    
}
