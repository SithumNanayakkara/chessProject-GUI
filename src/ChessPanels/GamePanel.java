/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessPanels;

import ChessDataBase.DBUserInfo;
import ChessDataBase.User;
import ChessDataBase.processUserInfo;
import ChessLogic.Board.Board;
import ChessLogic.Common.Colour;
import ChessLogic.Common.ProcessMove;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.HashSet;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class GamePanel extends javax.swing.JPanel {

    //private final DBUserInfo DB;
    //private User user;
    private final Board chessBoard;
    private final MenuPanel menuPanel;
    private final BoardPanel boardPanel;
    private final processUserInfo info;
    private final ProcessMove pm;
    private final Color colour1 = new java.awt.Color(0,204,204);//new java.awt.Color(204,255,255);
    private final Color colour2 = new java.awt.Color(0,102,102);
    private final String [] pieces;

    /**
     * Creates new form GamePanel
     */
    public GamePanel(MenuPanel menu, processUserInfo info) {
        initComponents();
        pieces  = new String [] {"",""};
        this.info = info;
        this.chessBoard = new Board();
        this.pm = new ProcessMove();
        this.boardPanel = new BoardPanel(this,pm,chessBoard);
        this.add(boardPanel);
        this.menuPanel = menu;
        this.jPanel2.add(turnsLabel);
        updateInfo ();
        this.validate();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        GradientPaint gp = new GradientPaint(0, 0, colour1, 1920, 720, colour2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, 1920, 720);
    }
    
    public void updateInfo ()
    {
        this.jPanel2.remove(turnsLabel);
        this.jPanel2.remove(invalidMoveLabel);
        
        if(pm.getColour() == "White")
        {
            this.turnsLabel.setText(pm.showWhoMoves()+ "'s turn to move!" +" ("+ this.info.getUser().getUserName()+")");;
        }
        else
            this.turnsLabel.setText(pm.showWhoMoves()+ "'s turn to move!" +" ("+"Guest"+")");
        this.invalidMoveLabel.setText(pm.getInvalidMove());
        this.jPanel2.add(invalidMoveLabel);
        this.jPanel2.add(turnsLabel);
        this.jPanel2.validate();
        this.jPanel2.repaint();
    }
    
    public void updatePieceInfo(String piece)
    {
        this.jPanel2.remove(pieceLabel);
        if(pieces[0] == "")
        {
            pieces[0] = piece;
        }
        else 
            pieces[1] = piece;
        
        
        
        this.pieceLabel.setText("First click: " + pieces[0] +" Second click: " + pieces[1]);
        this.jPanel2.add(pieceLabel);
        this.pieceLabel.validate();
        this.pieceLabel.repaint();
        
        
        if(pieces[0] != "" && pieces[1] != "")
        {
            pieces[0] = "";
            pieces[1] = "";
        }
    }
    
    public void increaseScore()
    {
        this.info.getUser().setScore(this.info.getUser().getScore()+10);
    }
    
    public void decreaseScore()
    {
        this.info.getUser().setScore(this.info.getUser().getScore()-10);
    }
    
    public void displayWin()
    {
        this.jPanel2.remove(turnsLabel);
        if(pm.getColour() == "Black")
        {
            increaseScore();
            this.info.updateDB();
            this.turnsLabel.setText("WHITE WINS!" +" ("+ this.info.getUser().getUserName()+")");
        }
        else
        {
            decreaseScore();
            this.info.updateDB();
            this.turnsLabel.setText("BLACK WINS!");
        }
        
        this.jPanel2.add(turnsLabel);
        this.turnsLabel.validate();
        this.turnsLabel.repaint();
    }
         
    public void displayScore()
    {
        this.jPanel2.remove(invalidMoveLabel);
        
        if(pm.getColour() == "Black")
        {
           this.invalidMoveLabel.setText("Current Score: " + this.info.getUser().getScore()+ " (+10)");
        }
        else
            this.invalidMoveLabel.setText("Current Score: " + this.info.getUser().getScore()+ " (-10)");
        
        this.jPanel2.add(invalidMoveLabel);
        this.invalidMoveLabel.validate();
        this.invalidMoveLabel.repaint();
    }
            
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBackToMenu = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pieceLabel = new javax.swing.JLabel();
        turnsLabel = new javax.swing.JLabel();
        invalidMoveLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setOpaque(false);

        btnBackToMenu.setBackground(new java.awt.Color(60, 63, 65));
        btnBackToMenu.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnBackToMenu.setForeground(new java.awt.Color(51, 255, 255));
        btnBackToMenu.setText("Back to Menu");
        btnBackToMenu.setBorder(null);
        btnBackToMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBackToMenu.setDefaultCapable(false);
        btnBackToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToMenuActionPerformed(evt);
            }
        });

        jPanel2.setOpaque(false);

        pieceLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        pieceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        turnsLabel.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        turnsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        invalidMoveLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        invalidMoveLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(turnsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pieceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(invalidMoveLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(turnsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pieceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(invalidMoveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(420, Short.MAX_VALUE)
                .addComponent(btnBackToMenu)
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(243, 243, 243)
                .addComponent(btnBackToMenu)
                .addGap(21, 21, 21))
        );

        btnBackToMenu.setOpaque( false );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(720, 720, 720)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToMenuActionPerformed
        this.menuPanel.setupCard();
        this.menuPanel.updateScore();
    }//GEN-LAST:event_btnBackToMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackToMenu;
    private javax.swing.JLabel invalidMoveLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel pieceLabel;
    private javax.swing.JLabel turnsLabel;
    // End of variables declaration//GEN-END:variables
}
