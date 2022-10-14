/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessCommon_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class SignInUpPage extends javax.swing.JFrame {
    
    
    // private final 
    private final Register register = new Register();
    private final Login login = new Login();
    private DBUserInfo DBUser;
    private boolean success;
    

    /**
     * Creates new form SignInUpPage
     */
    public SignInUpPage(DBUserInfo DB) {
        initComponents();
        myInitComponents();
        eventHandler();
        this.setVisible(true);
        this.DBUser = DB;
        this.success = false;
    }
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

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
        jPanel2.setPreferredSize(new java.awt.Dimension(340, 502));

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
                .addGap(423, 423, 423)
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

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1280, 720);
        jPanel1.getAccessibleContext().setAccessibleName("");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/HomeBackgroundImage.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //initialising on the login page
    public void myInitComponents() 
    {
        this.jPanel2.add(login);
        login.setLocation(0,0);
        login.setSize(340, 502);
    }   
    
    /**
     * @param args the command line arguments
     */
    public void eventHandler() {
                
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
            }
        });
        
        login.addEventLogin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                String userName = login.getTxtLoginUser().getText();
                String password = login.getTxtLoginPw().getText();
                if(!userName.equals("") || !password.equals(""))
                {
                    if(DBUser.loginUser(userName, password))
                    {
                        success = true;
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
                
                if(!userName.equals("") || !password.equals("") || !email.equals(""))
                {
                    if(DBUser.registerUser(userName,email,password))
                    {
                        System.out.println("Register Successful");
                    }
                    else 
                    {
                        System.out.println("Register Failed");
                        JOptionPane.showMessageDialog(jPanel2,userName +"already exists, please try again or login","error",JOptionPane.PLAIN_MESSAGE);
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

    public boolean isSuccess() {
        return success;
    }
    
     
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    // End of variables declaration//GEN-END:variables
}
