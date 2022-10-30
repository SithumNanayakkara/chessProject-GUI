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
    
    public void clearValues()
    {
        this.initialXCoordinate = null;
        this.initialYCoordinate = null;
        this.finalXCoordinate = null;
        this.finalYCoordinate = null;
    }
   
}
