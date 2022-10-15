/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessPanels;

import ChessDataBase.DBUserInfo;
import ChessPanels.RegisterPanel;
import ChessPanels.LoginPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class SwitchLoginRegisterPanel extends javax.swing.JPanel {
    
    private final RegisterPanel register = new RegisterPanel();
    private final LoginPanel login = new LoginPanel();
    private DBUserInfo DBUser;
    private boolean success;

    /**
     * Creates new Panel LoginRegisterPanel
     * @param DB
     */
    public SwitchLoginRegisterPanel(DBUserInfo DB) {
        initComponents();
        myInitComponents();
        eventHandler();
        this.DBUser = DB;
        this.success = false;
    }

    public void myInitComponents() 
    {
        this.jPanel2.add(login);
        login.setLocation(0,0);
        login.setSize(340, 502);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(393, 393, 393)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(424, 424, 424))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1);
        jPanel1.setBounds(0, 0, 1280, 720);
    }// </editor-fold>//GEN-END:initComponents

    public void eventHandler()
    {
    
        //actions to show register form
        login.addEventBackToRegister(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //  Show register form
                jPanel2.removeAll();
                jPanel2.repaint();
                jPanel2.validate();
                jPanel2.add(register);
                jPanel2.repaint();
                jPanel2.validate();
                register.setLocation(0,0);
                register.setSize(340, 502);
                register.Register();
            }
        });
        
        //actions to go back to login form
        register.addEventBackToLogin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //  Show register form
                jPanel2.removeAll();
                jPanel2.repaint();
                jPanel2.validate();
                jPanel2.add(login);
                jPanel2.repaint();
                jPanel2.validate();
                login.setLocation(0,0);
                login.setSize(340, 502);
                login.Login();
            }
        });
        
        login.addEventLogin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                String userName = login.getTxtLoginUser().getText();
                String password = login.getTxtLoginPw().getText();
                if(!userName.equals("") && !password.equals(""))
                {
                    if(DBUser.loginUser(userName, password))
                    {
                        success = true;
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
        });
        
        register.addEventRegister(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                String userName = register.getTxtRegisterUser().getText();
                String password = register.getTxtRegisterPw().getText();
                String email = register.getTxtRegisterEmail().getText();
                
                if(!userName.equals("") && !password.equals("") && !email.equals(""))
                {
                    if(DBUser.registerUser(userName,email,password))
                    {
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
        });
        
        
    }
    
    //gets the value of success to proceed to the game menu
    public boolean isSuccess() {
        return success;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
