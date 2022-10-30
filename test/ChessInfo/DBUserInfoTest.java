/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessInfo;

import ChessInfo.User;
import ChessInfo.UserDataBase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class DBUserInfoTest {
    
    private UserDataBase DBUser;
    
    
    public DBUserInfoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class DBUserInfo.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        UserDataBase expResult = UserDataBase.getInstance();
    }

    /**
     * Test of setupChessDB method, of class DBUserInfo.
     */
    @Test
    public void testSetupChessDB() {
        System.out.println("setupChessDB");
        UserDataBase instance = new UserDataBase();
        instance.setupChessDB();
    }

    /**
     * Test of checkExistedTable method, of class DBUserInfo.
     */
    @Test
    public void testCheckExistedTable() {
        System.out.println("checkExistedTable");
        String name = "ChessUserInfo";
        UserDataBase instance = new UserDataBase();
        boolean expResult = false;
        boolean result = instance.checkExistedTable(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of loginUser method, of class DBUserInfo.
     */
    @Test
    public void testLoginUserPass() {
        System.out.println("loginUser");
        String userName = "Sithum";
        String password = "sithum";
        UserDataBase instance = new UserDataBase();
        boolean expResult = true;
        boolean result = instance.loginUser(userName, password);
        assertEquals(expResult, result);
    }
    

    /**
     * Test of loginUser method, of class DBUserInfo. Test when details are entered wrong
     */
    @Test
    public void testLoginUserFail() {
        System.out.println("loginUser");
        String userName = "wrongusername";
        String password = "wrongpassword";
        UserDataBase instance = new UserDataBase();
        boolean expResult = false;
        boolean result = instance.loginUser(userName, password);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of loadUser method, of class DBUserInfo. When details are correct
     */
    @Test
    public void testLoadUser() {
        System.out.println("loadUser");
        String userName = "Sithum";
        String password = "sithum";
        UserDataBase instance = new UserDataBase();
        User expResult = new User("Sithum","sithum","sithum_nanayakkara@outlook.com",60,false,0);
        User result = instance.loadUser(userName, password);
        assertEquals(expResult.getUserName(), result.getUserName());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getScore(), result.getScore());
    }
    
    /**
     * Test of registerUser method, of class DBUserInfo.
     * WILL FAIL IF RUN MORE THAN ONCE! WHICH IS EXPECTED
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String userName = "test";
        String email = "test";
        String password = "test";
        UserDataBase instance = new UserDataBase();
        boolean expResult = true;
        boolean result = instance.registerUser(userName, email, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of closeConnections method, of class DBUserInfo.
     */
    @Test
    public void testCloseConnections() {
        System.out.println("closeConnections");
        UserDataBase instance = new UserDataBase();
        instance.closeConnections();
    }

    /**
     * Test of updateScore method, of class DBUserInfo.
     */
    @Test
    public void testUpdateScore() {
        System.out.println("updateScore");
        User user = new User("test","test","test",10,false,0);
        UserDataBase instance = new UserDataBase();
        instance.updateScore(user);
    }
    
}
