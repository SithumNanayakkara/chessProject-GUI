/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessDataBase;

import ChessPanels.MainForm;
import ChessPanels.SwitchLoginRegisterPanel;
import javax.swing.JOptionPane;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class processUserInfo 
{
    private final SwitchLoginRegisterPanel LRPanel;
    private final DBUserInfo DBUser;
    private final MainForm form;
    private User user;

    public processUserInfo(SwitchLoginRegisterPanel panel, MainForm form) {
        this.LRPanel = panel;
        this.DBUser = DBUserInfo.getInstance();
        this.form = form;
    }
    
    public void doLogin ()
    {
        String userName = LRPanel.getLUsername();
        String password = LRPanel.getLPassword();
        
        if(!userName.equals("") && !password.equals(""))
        {
            if(DBUser.loginUser(userName, password))
            {
                
                this.user = DBUser.loadUser(userName, password);
                form.showCard2();
                form.setMenuName(userName);
                System.out.println("Login Successful");
            }
            else 
            {
                System.out.println("Login Failed");
                JOptionPane.showMessageDialog(LRPanel,"Invalid credentials, please try again or get registered","error",JOptionPane.PLAIN_MESSAGE);
            } 
        }
        else
        {
            System.out.println("Username or Password field empty");
            JOptionPane.showMessageDialog(LRPanel,"All fields must be filled, please try again!","Error",JOptionPane.PLAIN_MESSAGE);
        }
                
    }
    
    public void doRegister()
    {
        String userName = LRPanel.getRUsername();
        String password = LRPanel.getRPassword();
        String email = LRPanel.getREmail();

        if(!userName.equals("") && !password.equals("") && !email.equals(""))
        {
            if(DBUser.registerUser(userName,email,password))
            {
                
                user = new User (userName,password,email,0);
                form.showCard2();
                form.setMenuName(userName);
                System.out.println("Register Successful");
            }
            else 
            {
                System.out.println("Register Failed");
                JOptionPane.showMessageDialog(LRPanel,userName +" already exists, please try again or login","error",JOptionPane.PLAIN_MESSAGE);
            }
        }
        else
        {
            System.out.println("Username, Password, Email field empty");
            JOptionPane.showMessageDialog(LRPanel,"All fields must be filled, please try again!","Error",JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void updateDB()
    {
        this.DBUser.updateScore(this.user);
    }
    
    public User getUser()
    {
        return user;
    }
}
