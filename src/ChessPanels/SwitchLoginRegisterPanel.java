/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessPanels;

import ChessDataBase.DBUserInfo;
import java.awt.CardLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class SwitchLoginRegisterPanel extends javax.swing.JPanel {
    
    private final RegisterPanel register; 
    private final LoginPanel login;
    private final MainForm form;
    private final DBUserInfo DBUser;
    
    private CardLayout cardLayout;

    /**
     * Creates new Panel LoginRegisterPanel
     * @param form
     */
    public SwitchLoginRegisterPanel(MainForm form) 
    {
        initComponents();
        
        this.register = new RegisterPanel(this);
        this.login = new LoginPanel(this);
        this.form = form;
        this.DBUser = new DBUserInfo();
        
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
                .addGap(393, 393, 393)
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

    private void setupCard()
    {
        jPanel2.add(register,"register");
        jPanel2.add(login,"login");
        cardLayout = (CardLayout) (jPanel2.getLayout());
        cardLayout.show(jPanel2, "login");
    }
    
    public void showLoginCard ()
    {
        cardLayout.show(jPanel2, "login");
    }
    
    public void showRegisterCard ()
    {
        cardLayout.show(jPanel2, "register");
    }
    
    public void doLogin ()
    {
        String userName = login.getTxtLoginUser().getText();
        String password = login.getTxtLoginPw().getText();
        if(!userName.equals("") && !password.equals(""))
        {
            if(DBUser.loginUser(userName, password))
            {
                form.showCard2();
                form.setMenuName(userName);

                login.clearFields();
                System.out.println("Login Successful");
            }
            else 
            {
                login.clearFields();
                System.out.println("Login Failed");
                JOptionPane.showMessageDialog(jPanel2,"Invalid credentials, please try again or get registered","error",JOptionPane.PLAIN_MESSAGE);
            } 
        }
        else
        {
            System.out.println("Username or Password field empty");
            JOptionPane.showMessageDialog(jPanel2,"All fields must be filled, please try again!","Error",JOptionPane.PLAIN_MESSAGE);
        }
                
    }
    
    public void doRegister()
    {
        String userName = register.getTxtRegisterUser().getText();
                String password = register.getTxtRegisterPw().getText();
                String email = register.getTxtRegisterEmail().getText();
                
                if(!userName.equals("") && !password.equals("") && !email.equals(""))
                {
                    if(DBUser.registerUser(userName,email,password))
                    {
                        form.showCard2();
                        login.clearFields();
                        form.setMenuName(userName);
                        System.out.println("Register Successful");
                    }
                    else 
                    {
                        System.out.println("Register Failed");
                        JOptionPane.showMessageDialog(jPanel2,userName +" already exists, please try again or login","error",JOptionPane.PLAIN_MESSAGE);
                    }
                }
                else
                {
                    System.out.println("Username, Password, Email field empty");
                    JOptionPane.showMessageDialog(jPanel2,"All fields must be filled, please try again!","Error",JOptionPane.PLAIN_MESSAGE);
                }
    }
    
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
