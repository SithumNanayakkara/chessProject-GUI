/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessCommon;

import ChessBoard.Board;
import ChessPanels.BoardPanel;
import ChessPanels.BoardTiles;
import ChessPanels.GamePanel;
import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class MovePiece{

    private final ProcessMove pMove; 
    private final BoardPanel boardPanel;
    private final GamePanel gamePanel;
    private final Board chessBoard;
    private Integer initialXCoordinate;
    private Integer finalXCoordinate;
    private Integer initialYCoordinate;
    private Integer finalYCoordinate;
    private boolean gameOver;
    
    //constructor to initialise the ProcessMove, BoardPanel, GamePanel, and Board instances
    public MovePiece(ProcessMove pMove, BoardPanel bPanel, GamePanel gPanel, Board cb) 
    {
       this.gameOver = false;
       this.pMove  = pMove;
       this.boardPanel = bPanel;
       this.chessBoard = cb;
       this.gamePanel = gPanel;
       this.initialXCoordinate = null;
       this.finalXCoordinate = null;
       this.initialYCoordinate = null;
       this.finalYCoordinate = null;
    }

    /**
     * checks if the mouse click was the left or right mouse button and sets up 
     * the coordinates to be processed
     * @param tileCol - column number of the tile
     * @param tileRow - row number of the tile
     * @param event - mouse event listener
     * @param tile - tile instance
     */
    
    public void getMove(int tileCol, int tileRow, java.awt.event.MouseEvent event, BoardTiles tile)
    {
        if(isLeftMouseButton(event))
        {
            if(this.initialXCoordinate == null || this.initialYCoordinate == null)
            {
                if((chessBoard.getCell(tileCol, tileRow).getPiece()) != null)
                {
                    this.initialXCoordinate = tileCol;
                    this.initialYCoordinate = tileRow;
                }
            }
            else
            {
                this.finalXCoordinate = tileCol;
                this.finalYCoordinate = tileRow;
            }
        }
        else if(isRightMouseButton(event))
        {
            clearValues();
        }
        
        if(initialXCoordinate != null && initialYCoordinate != null && finalXCoordinate != null && finalYCoordinate != null)
        {
            System.out.println(this.initialXCoordinate+","+this.initialYCoordinate+" to "+this.finalXCoordinate+","+this.finalYCoordinate);
            doMove(tile);
        }

    }
    /**
     * checks if the game is over, if not it checks if the winning condition has
     * reached (either players have been checkmated) if not true it will proceed
     * to process the move setup by the earlier method. Once the move has been 
     * performed it checks if the winning condition was met again before exiting
     * if winning condition is met, the GUI will update to show who won and the 
     * score will also be updated
     * @param tile 
     */
    public void doMove(BoardTiles tile)
    { 
        if(!gameOver)
        {
            if(!pMove.winningCondition())
            {
                pMove.getMoveCells(this.initialXCoordinate, this.initialYCoordinate, this.finalXCoordinate, this.finalYCoordinate);
                clearValues();
                gamePanel.updateInfo();
                boardPanel.createPanels();
            }
            if(pMove.winningCondition())
            {
                gamePanel.displayWin();
                gamePanel.displayScore();
                gameOver = true;
            }
        }
    }
    /**
     * clears all values set by the mouse listener
     */
    public void clearValues()
    {
        this.initialXCoordinate = null;
        this.initialYCoordinate = null;
        this.finalXCoordinate = null;
        this.finalYCoordinate = null;
    }
   
}
