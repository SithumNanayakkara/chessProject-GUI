/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessCommon_GUI;

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
        SignInUpPage SIUPage = new SignInUpPage(DB);
        if(SIUPage.isSuccess())
        {
            //start game
            
        }
     }
     
}
