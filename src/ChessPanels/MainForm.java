/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessPanels;

import ChessInfo.processDataBase;
import java.awt.CardLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class MainForm extends javax.swing.JFrame {
    
    // private final 
    private final SwitchLoginRegisterPanel LRPanel;
    private final processDataBase processInfo;
    private final CardLayout cardLayout;
    private MenuPanel MPanel;
    
    /**
     * Creates new Main form SignInUpPage
     */
    public MainForm() {
        
        initComponents();
        LRPanel = new SwitchLoginRegisterPanel(this);
        processInfo = new processDataBase(LRPanel,this);
        jPanel1.add(LRPanel,"1");
        cardLayout = (CardLayout) (jPanel1.getLayout());
        cardLayout.show(jPanel1,"1");
        setBackground();
        this.setVisible(true);
    }
    
    private void setBackground()
    {
        try {
            jLabel2.setIcon( new ImageIcon(ImageIO.read(getClass().getResource("/resources/BkgImage.jpg"))));
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showCard1 ()
    {
        cardLayout.show(jPanel1,"1");
    }
    
    public void showCard2 ()
    {
        MPanel = new MenuPanel(this,processInfo);
        jPanel1.add(MPanel,"2");
        cardLayout.show(jPanel1,"2");
    }
    
    public void setMenuName(String name)
    {
        MPanel.welcomeName(name);
    }
    
    public void doLogin ()
    {
        this.processInfo.doLogin();
    }
    
    public void doRegister ()
    {
        this.processInfo.doRegister();
    }
    
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chess Game");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(new java.awt.CardLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setName(""); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
