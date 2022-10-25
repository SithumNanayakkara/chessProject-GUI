/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessPanels;

import ChessDataBase.processUserInfo;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class MenuPanel extends javax.swing.JPanel {
    
    private final processUserInfo info;
    private final MainForm form;
    private final RulesPanel rulesPanel;
    private CardLayout cardLayout;


    /**
     * Creates new panel MenuPanel
     * @param form
     */
    public MenuPanel(MainForm form, processUserInfo info) 
    {
        initComponents();
        this.form = form;
        rulesPanel = new RulesPanel(this);
        this.info = info;
        setupCard();
    }
    
    
    public void welcomeName(String name)
    {
        lblWelcome.setText("Hi "+ name + "!");
        updateScore();
    }
    
    public void setupCard()
    {
        this.add(jPanel1,"Main");
        this.add(rulesPanel,"Rules");
        cardLayout = (CardLayout) (this.getLayout());
        cardLayout.show(this, "Main");
    }
    
    public void updateScore()
    {
        this.jPanel1.remove(lblScore);
        this.lblScore.setText("Current Score: " + this.info.getUser().getScore());
        this.jPanel1.add(lblScore);
        this.lblScore.validate();
        this.lblScore.repaint();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        btnLoadGame = new javax.swing.JButton();
        btnRules = new javax.swing.JButton();
        btnNewGame = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblScore = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setOpaque(false);
        setLayout(new java.awt.CardLayout());

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        lblWelcome.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(204, 255, 255));
        lblWelcome.setText("Hi .......!");

        btnLoadGame.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        btnLoadGame.setForeground(new java.awt.Color(204, 255, 255));
        btnLoadGame.setText("Load Game");
        btnLoadGame.setToolTipText("");
        btnLoadGame.setBorder(null);
        btnLoadGame.setBorderPainted(false);
        btnLoadGame.setContentAreaFilled(false);
        btnLoadGame.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnRules.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        btnRules.setForeground(new java.awt.Color(204, 255, 255));
        btnRules.setText("Rules");
        btnRules.setToolTipText("");
        btnRules.setBorder(null);
        btnRules.setBorderPainted(false);
        btnRules.setContentAreaFilled(false);
        btnRules.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRulesActionPerformed(evt);
            }
        });

        btnNewGame.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        btnNewGame.setForeground(new java.awt.Color(204, 255, 255));
        btnNewGame.setText("New Game");
        btnNewGame.setToolTipText("");
        btnNewGame.setBorder(null);
        btnNewGame.setBorderPainted(false);
        btnNewGame.setContentAreaFilled(false);
        btnNewGame.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGameActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(204, 255, 255));
        btnLogout.setText("Logout");
        btnLogout.setToolTipText("");
        btnLogout.setBorder(null);
        btnLogout.setBorderPainted(false);
        btnLogout.setContentAreaFilled(false);
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        btnExit.setForeground(new java.awt.Color(204, 255, 255));
        btnExit.setText("Exit");
        btnExit.setToolTipText("");
        btnExit.setBorder(null);
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblScore.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblScore.setForeground(new java.awt.Color(204, 255, 255));
        lblScore.setText("Hi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLoadGame, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnExit)
                            .addComponent(btnNewGame)
                            .addComponent(btnRules))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(580, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(lblWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(btnNewGame)
                .addGap(60, 60, 60)
                .addComponent(btnLoadGame)
                .addGap(60, 60, 60)
                .addComponent(btnRules)
                .addGap(60, 60, 60)
                .addComponent(btnExit)
                .addGap(18, 18, 18)
                .addComponent(btnLogout)
                .addContainerGap())
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
       form.showCard1();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnRulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRulesActionPerformed
        cardLayout.show(this, "Rules");
    }//GEN-LAST:event_btnRulesActionPerformed

    private void btnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGameActionPerformed
        final GamePanel gamePanel = new GamePanel(this,this.info);
        this.add(gamePanel, "Game");
        cardLayout.show(this, "Game");
    }//GEN-LAST:event_btnNewGameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLoadGame;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNewGame;
    private javax.swing.JButton btnRules;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
}
