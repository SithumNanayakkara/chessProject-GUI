/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessCommon_GUI;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class DBUserInfo {
    
    private final DBConnection dbConnect;
    private final Connection conn;
    private Statement statement;
    
    public DBUserInfo ()
    {
        dbConnect = new DBConnection();
        System.out.println(dbConnect.getConnection());
        conn = dbConnect.getConnection();
        connectChessDB();
    }
    
    public void connectChessDB() {
        try {
            this.statement = conn.createStatement();
            if(!this.checkExistedTable("Chess_Players"))
            {
                this.statement.addBatch("CREATE  TABLE Chess_Players (USERNAME VARCHAR(255), EMAIL VARCHAR(255), PASSWORD VARCHAR(255), SCORE INTEGER)");
                this.statement.addBatch("INSERT INTO Chess_Players (USERNAME,EMAIL,PASSWORD,SCORE) VALUES"
                 + "('Sithum', 'sithum_nanayakkara@outlook.com', 'sithum', 60)");
                this.statement.executeBatch();
                System.out.println("Chess_Players Table has been created with Sample data");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public boolean checkExistedTable(String name) {
        boolean tableAlreadyExists = false;
        try {
            DatabaseMetaData dbmd = this.conn.getMetaData();
            String[] types = {"TABLE"};
            statement = this.conn.createStatement();
            ResultSet rs = dbmd.getTables(null, null, null, null);

            while (rs.next()) {
                String table_name = rs.getString("TABLE_NAME");
                //System.out.println(table_name);
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

    public void closeConnection() {
        this.dbConnect.closeConnections();
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
    
}
