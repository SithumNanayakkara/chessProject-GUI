/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessDataBase;

import ChessBoard.Board;
import ChessBoard.BoardCell;
import ChessPanels.MainForm;
import ChessPanels.SwitchLoginRegisterPanel;
import javax.swing.JOptionPane;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class processDataBase 
{
    private final SwitchLoginRegisterPanel LRPanel;
    private final UserDataBase DBUser;
    private final MainForm form;
    private BoardCell cell;
    private Board board;
    private User user;
    private boolean gameSaved;

    public processDataBase(SwitchLoginRegisterPanel panel, MainForm form) {
        this.LRPanel = panel;
        this.DBUser = UserDataBase.getInstance();
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
            if(!userName.contains(" "))
            {
                
                if(DBUser.registerUser(userName,email,password))
                {

                    user = new User (userName,password,email,0,false,0);
                    form.showCard2();
                    form.setMenuName(userName);

                    this.DBUser.makeProgressTable(user.getUserName());

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
                System.out.println("Username contains spaces");
                JOptionPane.showMessageDialog(LRPanel,"Username can not contain spaces! Please try again","error",JOptionPane.PLAIN_MESSAGE);
            }
        }
        else
        {
            System.out.println("Username, Password, Email field empty");
            JOptionPane.showMessageDialog(LRPanel,"All fields must be filled, please try again!","Error",JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    public void setClearProgress()
    {
        this.DBUser.clearGameProgress(user.getUserName());
    }
    
    public void setProgressTableInfo(String piece, int x, int y)
    {
        this.DBUser.addGameProgress(user.getUserName(), piece, x, y);
    }
    
    public void getProgressTableInfo(Board board)
    {
        int count = 0;
        if(!this.DBUser.getStoredPiece(user.getUserName()).isEmpty())
        {
           for(int c=0; c<64; c++)
           {
               String piece = this.DBUser.getStoredPiece(user.getUserName()).get(count);
               int xValue = this.DBUser.getStoredX(user.getUserName()).get(count);
               int yValue = this.DBUser.getStoredY(user.getUserName()).get(count);
               board.loadSavedCells(piece, xValue, yValue);
               count++; 
           }
        } 
    }
    
    public void setTurn(int whiteMoves)
    {
        this.user.setTurn(whiteMoves);
        this.DBUser.updateTurn(user);
    }
    
    public int getTurn()
    {
         return this.DBUser.getTurn(user.getUserName());
    }
    
    public void setGameSaved(Boolean gameSaved)
    {
        this.user.setGameLoaded(gameSaved);
        this.DBUser.updateGameSaved(user);
    }
    
    public boolean isGameSaved()
    {
         return this.DBUser.isGameSaved(user.getUserName());
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
