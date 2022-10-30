/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessPanels;

import ChessCommon.MovePiece;
import ChessBoard.Board;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class BoardTiles extends javax.swing.JPanel {
    
    private final Color colour1 = new java.awt.Color(204,255,255);
    private final Color colour2 = new java.awt.Color(0,102,102);
    
    private final Board board;
    private final MovePiece move;
    private final GamePanel gamePanel;
    
    private final int tileCol;
    private final int tileRow;
    /**
     * initialises all the instances and sets the tile colour and the piece
     * @param panels - BoardPanel instance
     * @param tileCol - column number
     * @param tileRow - row number
     * @param mp - MovePiece instance
     * @param cb - Board instance
     * @param gp - GamePanel instance
     */
    public BoardTiles(BoardPanel panels,int tileCol, int tileRow, MovePiece mp , Board cb, GamePanel gp) {
        initComponents();
        this.tileCol = tileCol;
        this.tileRow = tileRow;
        this.move = mp;
        this.board = cb;
        this.gamePanel = gp;
        tileColour();
        setPiece();
        validate();
    }
    /**
     * sets the piece by comparing the toString of the piece and the file
     * name of a png and sets the image on the tile if they match
     */
    private void setPiece()
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
    /**
     * gives all the tiles a color depending on the location
     */
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
    /**
     * uses a mouse listener on the tilePanel to listen for clicks on each tile 
     * and send the location of the mouse click to be further processed
     * @param evt 
     */
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

        String piece;
        if(board.getCell(tileCol, tileRow).getPiece() != null)
        {
            piece = board.getCell(tileCol, tileRow).getPiece().toString() + " (" + tileCol + "," + tileRow + ")";
        }
        else 
        {
            piece = "empty" + " (" + tileCol + "," + tileRow + ")";
        }
        
        gamePanel.updatePieceInfo(piece);
        
        move.getMove(this.tileCol,this.tileRow,evt,this);
    }//GEN-LAST:event_formMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
