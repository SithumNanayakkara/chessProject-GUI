/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessPanels;

import ChessLogic.Board.Board;
import ChessLogic.Common.ProcessMove;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class BoardTiles extends javax.swing.JPanel {
    
    private final static Dimension GAMEBOARD_TILE_DIMENSION = new Dimension(90,90);
    
    //private ProcessCoordinates coordinates;
    private final Color colour1 = new java.awt.Color(204,255,255);
    private final Color colour2 = new java.awt.Color(0,102,102);
    
    private final Board board;
    private final MovePiece move;
    //private final BoardPanel boardPanel;
    
    private final int tileCol;
    private final int tileRow;
    /**
     * Creates new form NewJPanel
     */
    public BoardTiles(BoardPanel panels,int tileCol, int tileRow, MovePiece mp , Board cb) {
        initComponents();
        this.tileCol = tileCol;
        this.tileRow = tileRow;
        //this.boardPanel = panels;
        this.move = mp;
        this.board = cb;
        tileColour();
        setPiece();
        validate();
    }
    
    public void setPiece()
    {
        this.removeAll();
        if((board.getCell(tileCol, tileRow).getPiece()) != null)
        {
            String fileName = board.getCell(tileCol, tileRow).getPiece().toString();
            add(new JLabel (new ImageIcon(getClass().getResource("/resources/"+ fileName +".png"))));
        }
        this.validate();
        this.repaint();
    }
    
    private void tileColour() 
    {
        
        if(tileRow %2 ==0)
        {
            if(tileCol %2 ==0)
            {
                this.setBackground(colour1);
            }
            else
                this.setBackground(colour2);
        }
        else
        {
            if(tileCol %2 ==0)
            {
                this.setBackground(colour2);
            }
            else
                this.setBackground(colour1);
        }
           
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(1280, 720));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        move.getMove(this.tileCol,this.tileRow,evt,this);
    }//GEN-LAST:event_formMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
