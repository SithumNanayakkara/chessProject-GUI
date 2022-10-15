/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessPanels;

import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class MenuPanel extends javax.swing.JPanel {
    
    MainForm form;

    /**
     * Creates new panel MenuPanel
     */
    public MenuPanel(MainForm form) 
    {
        initComponents();
        this.form = form;
    }
    
    public void welcomeName(String name)
    {
        lblWelcome.setText("Hi "+ name + "!");
    }

    public void addEventExit(ActionListener event)
    {
        btnExit.addActionListener(event);
    }
    
    public void addEventLogout(ActionListener event)
    {
        btnLogout.addActionListener(event);
    }
    
    public void addEventNewGame(ActionListener event)
    {
        btnNewGame.addActionListener(event);
    }
    
    public void addEventRules(ActionListener event)
    {
        btnRules.addActionListener(event);
    }
    
    public void addEventLoadGame(ActionListener event)
    {
        btnLoadGame.addActionListener(event);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblWelcome = new javax.swing.JLabel();
        btnLoadGame = new javax.swing.JButton();
        btnRules = new javax.swing.JButton();
        btnNewGame = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setOpaque(false);

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

        btnNewGame.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        btnNewGame.setForeground(new java.awt.Color(204, 255, 255));
        btnNewGame.setText("New Game");
        btnNewGame.setToolTipText("");
        btnNewGame.setBorder(null);
        btnNewGame.setBorderPainted(false);
        btnNewGame.setContentAreaFilled(false);
        btnNewGame.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLoadGame)
                    .addComponent(btnExit)
                    .addComponent(btnNewGame)
                    .addComponent(btnRules)
                    .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(580, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(lblWelcome)
                .addGap(80, 80, 80)
                .addComponent(btnNewGame)
                .addGap(50, 50, 50)
                .addComponent(btnLoadGame)
                .addGap(50, 50, 50)
                .addComponent(btnRules)
                .addGap(50, 50, 50)
                .addComponent(btnExit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        form.card1();
    }//GEN-LAST:event_btnLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLoadGame;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNewGame;
    private javax.swing.JButton btnRules;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
}
