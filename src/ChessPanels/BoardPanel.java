/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessPanels;

import ChessLogic.Common.MovePiece;
import ChessLogic.Board.Board;
import ChessLogic.Common.ProcessMove;
import java.awt.Dimension;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class BoardPanel extends javax.swing.JPanel {
  
    final List<BoardTiles> tiles;
    private final Board chessBoard;
    private final MovePiece movePiece;
    
    private final static Dimension GAMEBOARD_PANEL_DIMENSION = new Dimension(720,720);
    
    /**
     * Creates new form GamePanel
     * @param gp
     * @param pm
     * @param cb
     */
    public BoardPanel(GamePanel gp, ProcessMove pm, Board cb) {
        initComponents();
        this.tiles = new ArrayList<>();
        this.movePiece = new MovePiece(pm,this,gp,cb);
        this.chessBoard = cb;
        this.chessBoard.setup();
        this.setSize(GAMEBOARD_PANEL_DIMENSION);
        this.setLocation(0, 0);
        createPanels();
        this.validate( );
    }
    
    public final void createPanels()
    {
        this.removeAll();
        for (int c=0; c<8; c++)
        {
            for(int r=0; r<8; r++)
            {
                final BoardTiles tilePanel = new BoardTiles(this,c,r,movePiece, chessBoard);
                this.add(tilePanel);
                this.tiles.add(tilePanel);
            }
        }
        this.validate();
        this.repaint();
    }  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(153, 255, 255), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 255, 255)));
        setOpaque(false);
        setLayout(new java.awt.GridLayout(8, 8));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
