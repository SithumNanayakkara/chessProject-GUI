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
    }
    
    public void connectChessDB() {
        try {
            this.statement = conn.createStatement();
            this.checkExistedTable("Chess_Players");
            this.statement.addBatch("CREATE  TABLE Chess_Players (USERNAME VARCHAR(255), EMAIL VARCHAR(255), PASSWORD VARCHAR(255), SCORE INTEGER)");
            this.statement.addBatch("INSERT INTO Chess_Players (USERNAME,EMAIL,PASSWORD,SCORE) VALUES"
             + "('Sithum Nanayakkara', 'sithum@nanayakkara.com', 'sithum', 60)");
            this.statement.executeBatch();
            System.out.println("Chess_Players Table has been created with Sample data");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void checkExistedTable(String name) {
        try {
            DatabaseMetaData dbmd = this.conn.getMetaData();
            String[] types = {"TABLE"};
            statement = this.conn.createStatement();
            ResultSet rs = dbmd.getTables(null, null, null, types);

            while (rs.next()) {
                String table_name = rs.getString("TABLE_NAME");
                System.out.println(table_name);
                if (table_name.equalsIgnoreCase(name)) {
                    statement.executeUpdate("Drop table " + name);
                    System.out.println("Table " + name + " has been deleted.");
                    break;
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void closeConnection() {
        this.dbConnect.closeConnections();
    }
    
}