/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessInfo;

import ChessBoard.BoardCell;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public final class UserDataBase {
    
    private static UserDataBase db;
    private static final String USER_NAME = "Chess"; //DB username
    private static final String PASSWORD = "Chess"; // DB password
    private static final String URL = "jdbc:derby:ChessUserInfo; create=true";//url of the DB host
    
    private Connection conn;
    private Statement statement;
    
    /**
     * constructor which calls the establish connection method 
     * which establishes the connection with the derby embedded server
     */
    protected UserDataBase()
    {
        if(!establishConnection())
        {
            JOptionPane.showMessageDialog(null,"Database connection failed,"
                    + " please make sure all other instances of the game are "
                    + "closed","Error - Starting Database",JOptionPane.ERROR_MESSAGE);
            System.out.println("Database connection failed, please make sure all "
                    + "other instances of the game is closed");
            System.exit(0);
        }
        
        setupChessDB();
        System.out.println(this.conn);
    }
    /**
     * gets the instance of this class as it is a protected class (singleton pattern)
     * @return 
     */
    public static UserDataBase getInstance()
    {
         if (db == null)  
        {  
            db = new UserDataBase();  
        }  
        return db;  
        
    }
    
    //Establish connection
    protected boolean establishConnection() {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " Get Connected Successfully ....");
                return true;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }
    /**
     * sets up the initial DB table call chess_players which stores all the 
     * information about the user plus the game states
     */
    protected void setupChessDB() {
        try {
            this.statement = conn.createStatement();
            if(!this.checkExistedTable("Chess_Players"))
            {
                this.statement.addBatch("CREATE  TABLE Chess_Players (USERNAME VARCHAR(255) NOT NULL, EMAIL VARCHAR(255) NOT NULL, PASSWORD VARCHAR(255) NOT NULL, SCORE INTEGER NOT NULL, LOADEDGAME BOOLEAN, TURN INTEGER, PRIMARY KEY (USERNAME))");
                this.statement.addBatch("INSERT INTO Chess_Players (USERNAME,EMAIL,PASSWORD,SCORE, LOADEDGAME, TURN) VALUES"
                                            + "('Sithum', 'sithum_nanayakkara@outlook.com', 'sithum', 60, FALSE, 0)");
                this.statement.addBatch("CREATE  TABLE Sithum (PIECE VARCHAR(255) , X INTEGER NOT NULL, Y INTEGER NOT NULL)");
                this.statement.executeBatch();
                System.out.println("Chess_Players Table and Sithum has been created");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * loads the user to the user class so the values can be accessed by 
     * other classes
     * @param userName
     * @param password
     * @return 
     */
    protected User loadUser(String userName, String password)
    {
        User user =null;
        try 
        {
            ResultSet rs = statement.executeQuery("SELECT * FROM Chess_Players WHERE USERNAME= '" + userName+ "' AND PASSWORD = '" + password + "'");
            if (rs.next()) {
                user = new User(rs.getString("USERNAME"),rs.getString("PASSWORD"),rs.getString("EMAIL"),rs.getInt("SCORE"), rs.getBoolean("LOADEDGAME"), rs.getInt("TURN"));
                System.out.println("User data loaded");
            }
            rs.close();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return user;
    }
    /**
     * registers the user - writing to DB
     * @param userName
     * @param email
     * @param password
     * @return 
     */
    protected boolean registerUser(String userName, String email, String password)
    {
        boolean registerSuccess = false;
        try {
            if (!loginUser(email, password)) {
                statement.executeUpdate("INSERT INTO Chess_Players (USERNAME, EMAIL, PASSWORD, SCORE, LOADEDGAME, TURN) VALUES ('" + userName + "', '" + email + "', '" + password + "', 0, FALSE, 0)");
                System.out.println("New user "+userName+" registered");
                registerSuccess = true;
            } 
            else 
            { 
                System.out.println(userName+ " already exists");
            }
            
        } catch (SQLException ex) 
        {
            System.err.println(ex.getMessage());
        }
        return registerSuccess;
    }
    /**
     * logs in the user - reading from DB
     * @param userName
     * @param password
     * @return 
     */
    protected boolean loginUser(String userName, String password)
    {
        boolean loginSuccess = false;
        try 
        {
            ResultSet rs = statement.executeQuery("SELECT USERNAME FROM Chess_Players WHERE USERNAME= '" + userName+ "' AND PASSWORD = '" + password + "'");
            if (rs.next()) {
                loginSuccess = true;
            }
            rs.close();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return loginSuccess;
    }
    /**
     * writing to DB - updates the turn number to be used for loading 
     * game purposes 
     * @param user 
     */
    protected void updateTurn(User user)
    {
        try {
            statement.executeUpdate("UPDATE Chess_Players SET TURN = " + user.getTurn() + " WHERE USERNAME = '" + user.getUserName() + "'");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * reading from DB - gets the saved turns
     * @param userName
     * @return 
     */
    protected int getTurn(String userName)
    {
        int turn = 0;
        try 
        {
            ResultSet rs = statement.executeQuery("SELECT * FROM Chess_Players WHERE USERNAME = '" + userName+ "'");
            if (rs.next()) {
                turn = rs.getInt("TURN");      
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return turn;
    }
    /**
     * writing to DB - stores whether there was a game already saved
     * @param user 
     */
    protected void updateGameSaved(User user)
    {
        try {
            statement.executeUpdate("UPDATE Chess_Players SET LOADEDGAME = " + user.isGameLoaded()+ " WHERE USERNAME = '" + user.getUserName() + "'");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * reading from DB - gets whether there was a saved state
     * @param userName
     * @return 
     */
    protected Boolean isGameSaved(String userName)
    {
        Boolean hasLoadedGame = true;
        try 
        {
            ResultSet rs = statement.executeQuery("SELECT * FROM Chess_Players WHERE USERNAME='" + userName+ "'");
            if (rs.next()) {
                hasLoadedGame = rs.getBoolean("LOADEDGAME");      
            }
            rs.close();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return hasLoadedGame;
    }
    /**
     * writing to DB - updates the score once the game is over
     * @param user 
     */
    protected void updateScore(User user)
    {
        try {
            statement.executeUpdate("UPDATE Chess_Players SET SCORE = " + user.getScore() + " WHERE USERNAME = '" + user.getUserName() + "'");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * makes a new table corresponding to the users name which stores the 
     * loaded game data
     * @param username 
     */
    protected void makeProgressTable(String username)
    {
        try {
            this.statement = conn.createStatement();
            if(!this.checkExistedTable(username))
            {
                this.statement.addBatch("CREATE  TABLE " + username.replace(" ", "_") + " (PIECE VARCHAR(255) , X INTEGER NOT NULL, Y INTEGER NOT NULL)");
                this.statement.executeBatch();
                System.out.println( username +"Table has been created");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }       
    }
    
    /**
     * clears the loaded game data
     * @param username 
     */
    protected void clearGameProgress(String username)
    {
        try {
            statement.execute("DELETE FROM " + username);
        } catch (SQLException ex) {
            Logger.getLogger(UserDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * writing to DB - adds the data to the earlier mentioned table
     * @param username
     * @param piece
     * @param x
     * @param y 
     */
    protected void addGameProgress(String username, String piece, int x, int y)
    {
        try {
            statement.executeUpdate("INSERT INTO " + username + " (PIECE, X, Y) VALUES('"+ piece +"',"+ x +","+ y +")");
        } catch (SQLException ex) {
            Logger.getLogger(UserDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * gets the piece data from table
     * @param username
     * @return 
     */
    protected ArrayList<String> getStoredPiece(String username)
    {
        ArrayList<String> pieceValues = new ArrayList<>();
        try 
        {
            ResultSet rs = statement.executeQuery("SELECT * FROM "+ username);
            while (rs.next()) {
                pieceValues.add(rs.getString("PIECE"));         
               
            }
            rs.close();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return pieceValues;
    }
    /**
     * gets the x coordinate from the table
     * @param username
     * @return 
     */
    protected ArrayList<Integer> getStoredX(String username)
    {
        ArrayList<Integer> xValues = new ArrayList<>();
        try 
        {
            ResultSet rs = statement.executeQuery("SELECT * FROM "+ username);
            while (rs.next()) {
               xValues.add(rs.getInt("X"));
            }
            rs.close();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return xValues;
    }
     /**
     * gets the y coordinate from the table
     * @param username
     * @return 
     */
    protected ArrayList<Integer> getStoredY(String username)
    {
        ArrayList<Integer> yValues = new ArrayList<>();
        try 
        {
            ResultSet rs = statement.executeQuery("SELECT * FROM "+ username);
            while (rs.next()) {
                
               yValues.add(rs.getInt("Y")) ;
            }
            rs.close();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return yValues;
    }
    
    /**
     * checks if the table already exists
     * @param name
     * @return 
     */
    protected boolean checkExistedTable(String name) {
        boolean tableAlreadyExists = false;
        try {
            DatabaseMetaData dbmd = this.conn.getMetaData();
            String[] types = {"TABLE"};
            statement = this.conn.createStatement();
            ResultSet rs = dbmd.getTables(null, null, null, null);

            while (rs.next()) {
                String table_name = rs.getString("TABLE_NAME");
                if (table_name.equalsIgnoreCase(name)) {
                    System.out.println("Table already Exists!");
                    tableAlreadyExists = true;
                    break;
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return tableAlreadyExists;
    }
    /**
     * closes connection
     */
    protected void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
}
