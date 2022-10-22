/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessDataBase;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class DBUserInfo {
    
    private static DBUserInfo db;
    private static final String USER_NAME = "Chess"; //DB username
    private static final String PASSWORD = "Chess"; // DB password
    private static final String URL = "jdbc:derby:ChessUserInfo; create=true";  //url of the DB host
    
   // private final DBConnection dbConnect;
    private Connection conn;
    private Statement statement;
    
    protected DBUserInfo()
    {
        if(!establishConnection())
        {
            JOptionPane.showMessageDialog(null,"Database connection failed, please make sure all other instances of the game are closed","Error - Starting Database",JOptionPane.ERROR_MESSAGE);
            System.out.println("Database connection failed, please make sure all other instances of the game is closed");
            System.exit(0);
        }
        
        setupChessDB();
        System.out.println(this.conn);
    }
    
    public static DBUserInfo getInstance()
    {
         if (db == null)  
        {  
            db = new DBUserInfo();  
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
    
    protected void setupChessDB() {
        try {
            this.statement = conn.createStatement();
            if(!this.checkExistedTable("Chess_Players"))
            {
                this.statement.addBatch("CREATE  TABLE Chess_Players (USERNAME VARCHAR(255) NOT NULL, EMAIL VARCHAR(255) NOT NULL, PASSWORD VARCHAR(255) NOT NULL, SCORE INTEGER NOT NULL, PRIMARY KEY (USERNAME))");
                this.statement.addBatch("INSERT INTO Chess_Players (USERNAME,EMAIL,PASSWORD,SCORE) VALUES"
                                            + "('Sithum', 'sithum_nanayakkara@outlook.com', 'sithum', 60)");
                this.statement.executeBatch();
                System.out.println("Chess_Players Table has been created with Sample data");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
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
    
    public boolean loginUser(String userName, String password)
    {
        boolean loginSuccess = false;
        try 
        {
            ResultSet rs = statement.executeQuery("SELECT USERNAME FROM Chess_Players WHERE USERNAME='" + userName+ "'AND PASSWORD = '" + password + "'");
            if (rs.next()) {
                loginSuccess = true;
            }
            rs.close();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return loginSuccess;
    }
    public boolean registerUser(String userName, String email, String password)
    {
        boolean registerSuccess = false;
        try {
            if (!loginUser(email, password)) {
                statement.executeUpdate("INSERT INTO Chess_Players (USERNAME, EMAIL, PASSWORD, SCORE) VALUES ('" + userName + "', '" + email + "', '" + password + "', 0)");
                System.out.println("New user "+userName+" registered");
                if(email != null || password != null)
                {
                    registerSuccess = true;
                }
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
    
    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
