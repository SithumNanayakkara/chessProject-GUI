/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessPanels;

import java.awt.CardLayout;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class MainForm extends javax.swing.JFrame {
    
    // private final 
    private final SwitchLoginRegisterPanel LRPanel;
    private final CardLayout cardLayout;
    private final MenuPanel MPanel;
    private String userName;
    
    /**
     * Creates new Main form SignInUpPage
     */
    public MainForm() {
        
        initComponents();
        LRPanel = new SwitchLoginRegisterPanel(this);
        MPanel = new MenuPanel(this);
        jPanel1.add(LRPanel,"1");
        jPanel1.add(MPanel,"2");
        cardLayout = (CardLayout) (jPanel1.getLayout());
        cardLayout.show(jPanel1,"1");
        this.setVisible(true);
        this.userName = "";
    }
    
    
    public void card1 ()
    {
        cardLayout.show(jPanel1,"1");
    }
    public void card2 ()
    {
        cardLayout.show(jPanel1,"2");
    }
    public void setMenuName(String name)
    {
        MPanel.welcomeName(name);
    }
    
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chess Game");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
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
    // End of variables declaration//GEN-END:variables
}
