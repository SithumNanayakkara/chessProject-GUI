/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessPanels;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;




/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class GamePanel extends javax.swing.JPanel {
    

    private final MenuPanel menuPanel;
    private final BoardPanel boardPanel;
    private final Color colour1 = new java.awt.Color(0,204,204);//new java.awt.Color(204,255,255);
    private final Color colour2 = new java.awt.Color(0,102,102);

    /**
     * Creates new form GamePanel
     */
    public GamePanel(MenuPanel menu) {
        initComponents();
        boardPanel = new BoardPanel(this);
        this.add(boardPanel);
        this.validate();
        this.menuPanel = menu;
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
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBackToMenu = new javax.swing.JButton();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(1142, Short.MAX_VALUE)
                .addComponent(btnBackToMenu)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(676, Short.MAX_VALUE)
                .addComponent(btnBackToMenu)
                .addGap(20, 20, 20))
        );

        btnBackToMenu.setOpaque( false );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToMenuActionPerformed
        this.menuPanel.setupCard();
    }//GEN-LAST:event_btnBackToMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackToMenu;
    // End of variables declaration//GEN-END:variables
}
