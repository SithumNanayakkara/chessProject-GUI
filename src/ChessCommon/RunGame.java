/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessCommon;

import ChessDataBase.DBUserInfo;
import ChessPanels.MainForm;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class RunGame 
{
     public static void main(String args[]) 
     {
        //Starting DB and connecting to embedded server       
        DBUserInfo DB = new DBUserInfo();
        //Entry point to the Game GUI
        MainForm form = new MainForm(DB);
        
     }
}
