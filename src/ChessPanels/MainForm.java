/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessPanels;

import ChessDataBase.DBUserInfo;
import ChessPanels.RegisterPanel;
import ChessPanels.LoginPanel;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class MainForm extends javax.swing.JFrame {
    
    
    // private final 
    private final RegisterPanel register = new RegisterPanel();
    private final LoginPanel login = new LoginPanel();
    private DBUserInfo DBUser;
    private boolean success;
    
    private final SwitchLoginRegisterPanel LRPanel;
    
    /**
     * Creates new Main form SignInUpPage
     */
    public MainForm(DBUserInfo DB) {
        initComponents();
        LRPanel = new SwitchLoginRegisterPanel(DB);
        jPanel1.add(LRPanel);
        this.setVisible(true);
        
        
    }
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chess Game");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.CardLayout());
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1280, 720);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/HomeBackgroundImage.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    // End of variables declaration//GEN-END:variables
}
