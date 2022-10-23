/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessLogic.Common;

import ChessLogic.Board.Board;
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
    
    public MovePiece(ProcessMove pMove, BoardPanel bPanel, GamePanel gPanel, Board cb) 
    {
        
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
            if(this.getInitialXCoordinate() == null || this.getInitialYCoordinate() == null)
            {
                this.setInitialXCoordinate(tileCol);
                this.setInitialYCoordinate(tileRow);
            }
            else
            {
                this.setFinalXCoordinate(tileCol);
                this.setFinalYCoordinate(tileRow);
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
        }
        
    }
    
    public void clearValues()
    {
            this.setInitialXCoordinate(null);
            this.setInitialYCoordinate(null);
            this.setFinalXCoordinate(null);
            this.setFinalYCoordinate(null);
    }
    
    public Integer getInitialXCoordinate() {
        return initialXCoordinate;
    }

    public void setInitialXCoordinate(Integer initialCoordinate) {
        this.initialXCoordinate = initialCoordinate;
    }

    public Integer getFinalXCoordinate() {
        return finalXCoordinate;
    }

    public void setFinalXCoordinate(Integer finalCoordinate) {
        this.finalXCoordinate = finalCoordinate;
    }
    
    public Integer getInitialYCoordinate() {
        return initialYCoordinate;
    }

    public void setInitialYCoordinate(Integer initialCoordinate) {
        this.initialYCoordinate = initialCoordinate;
    }

    public Integer getFinalYCoordinate() {
        return finalYCoordinate;
    }

    public void setFinalYCoordinate(Integer finalCoordinate) {
        this.finalYCoordinate = finalCoordinate;
    }
    
    
}
