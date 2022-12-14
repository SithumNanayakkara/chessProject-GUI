 /*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessPanels;

import ChessCommon.MovePiece;
import ChessBoard.Board;
import ChessCommon.ProcessMove;
import java.awt.Dimension;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class BoardPanel extends javax.swing.JPanel {
  
    private final Board chessBoard;
    private final MovePiece movePiece;
    private final GamePanel gamePanel;
    private final static Dimension GAMEBOARD_PANEL_DIMENSION = new Dimension(720,720);
    
    /**
     * Creates new form GamePanel
     * @param gp - GamePanel instance
     * @param pm - ProcessMove instance
     * @param cb - Board instance
     */
    public BoardPanel(GamePanel gp, ProcessMove pm, Board cb) {
        initComponents();
        this.movePiece = new MovePiece(pm,this,gp,cb);
        this.chessBoard = cb;
        this.gamePanel = gp;
        this.setSize(GAMEBOARD_PANEL_DIMENSION);
        this.setLocation(0, 0);
        createPanels();
        this.validate( );
    }
    
    /**
     * creates and adds 64 panels inside the BoardPanel JPanel
     */
    public final void createPanels()
    {
        this.removeAll();
        for (int c=0; c<8; c++)
        {
            for(int r=0; r<8; r++)
            {
                final BoardTiles tilePanel = new BoardTiles(this,c,r,movePiece, chessBoard, gamePanel);
                this.add(tilePanel);
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
