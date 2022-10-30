/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessPanels;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class SwitchLoginRegisterPanel extends javax.swing.JPanel {
    
    private final RegisterPanel register; 
    private final LoginPanel login;
    private final MainForm form;
    //private final processUserInfo processInfo;
    //private final DBUserInfo DBUser;
    
    private CardLayout cardLayout;

    /**
     * Creates new Panel LoginRegisterPanel
     * @param form
     */
    public SwitchLoginRegisterPanel(MainForm form) 
    {
        initComponents();
        this.register = new RegisterPanel();
        this.login = new LoginPanel();
        this.form = form;
        
        setupCard();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(null);

        jPanel1.setToolTipText("");
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("Welcome To Chess!");

        jPanel2.setMaximumSize(new java.awt.Dimension(340, 502));
        jPanel2.setMinimumSize(new java.awt.Dimension(340, 502));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(411, 411, 411)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(424, 424, 424))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1);
        jPanel1.setBounds(0, 0, 1280, 720);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * adds the register and login panels to a card layout
     */
    private void setupCard()
    {
        jPanel2.add(register,"register");
        jPanel2.add(login,"login");
        cardLayout = (CardLayout) (jPanel2.getLayout());
        cardLayout.show(jPanel2, "login");
        actions();
    }
    
    public void showLoginCard ()
    {
        cardLayout.show(jPanel2, "login");
    }
    
    public void showRegisterCard ()
    {
        cardLayout.show(jPanel2, "register");
    }
    
    public String getLUsername()
    {
        return login.getUserField().getText();
    }
    
    public String getLPassword()
    {
        return login.getPasswordField().getText();
    }
    
    public String getRUsername()
    {
        return register.getRegisterUserField().getText();
    }
    
    public String getRPassword()
    {
        return register.getRegisterPwField().getText();
    }
    
    public String getREmail()
    {
        return register.getRegisterEmailField().getText();
    }
    
    public void setName(String name)
    {
        form.setMenuName(name);
    }
    /**
     * all the action listeners from the login panel and the register panel
     */
    public void actions ()
    {
        this.login.getBtnBackToRegister().addActionListener((ActionEvent e) -> {
            showRegisterCard ();
        });
        
        this.login.getBtnLogin().addActionListener((ActionEvent e) -> {
            form.doLogin();
        });    
        
        this.login.getUserField().addActionListener((ActionEvent e) -> {
            login.getPasswordField().grabFocus();
        });  
        
        this.login.getPasswordField().addActionListener((ActionEvent e) -> {
            form.doLogin();
            login.clearFields();
        });   
        
        this.register.getBtnBackToLogin().addActionListener((ActionEvent e) -> {
            showLoginCard();
        });
        
        this.register.getBtnRegister().addActionListener((ActionEvent e) -> {
            form.doRegister();
        });
        
        this.register.getRegisterUserField().addActionListener((ActionEvent e) -> {
            register.getRegisterPwField().grabFocus();
        });    
        
        this.register.getRegisterPwField().addActionListener((ActionEvent e) -> {
            register.getRegisterEmailField().grabFocus();
        });  
        
        this.register.getRegisterEmailField().addActionListener((ActionEvent e) -> {
            form.doRegister();
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
