/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessInfo;

import ChessBoard.Board;
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
    private User user;

    public processDataBase(SwitchLoginRegisterPanel panel, MainForm form) {
        this.LRPanel = panel;
        this.DBUser = UserDataBase.getInstance();
        this.form = form;
    }
    /**
     * process the logged user
     */
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
    /**
     * process the registered user
     */
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
    /**
     * set method for the clear progress method in 
     */
    public void setClearProgress()
    {
        this.DBUser.clearGameProgress(user.getUserName());
    }
    /**
     * adding data method for the progress table method in DB
     */
    public void setProgressTableInfo(String piece, int x, int y)
    {
        this.DBUser.addGameProgress(user.getUserName(), piece, x, y);
    }
    /**
     * getting data method for the progress table method in DB
     */
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
    /**
     * sets the turns to the DB
     * @param whiteMoves 
     */
    public void setTurn(int whiteMoves)
    {
        this.user.setTurn(whiteMoves);
        this.DBUser.updateTurn(user);
    }
    /**
     * gets the turns from the DB
     * @return 
     */
    public int getTurn()
    {
         return this.DBUser.getTurn(user.getUserName());
    }
    /**
     * sets the game saved state to the DB
     * @param gameSaved 
     */
    public void setGameSaved(Boolean gameSaved)
    {
        this.user.setGameLoaded(gameSaved);
        this.DBUser.updateGameSaved(user);
    }
    /**
     * gets the game saved state from the DB
     * @return 
     */
    public boolean isGameSaved()
    {
         return this.DBUser.isGameSaved(user.getUserName());
    }
    /**
     * updates the user info in the DB
     */
    public void updateDB()
    {
        this.DBUser.updateScore(this.user);
    }
    /**
     * gets the user instance
     * @return 
     */
    public User getUser()
    {
        return user;
    }
}
