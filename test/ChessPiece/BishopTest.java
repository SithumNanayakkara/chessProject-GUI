/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessPiece;

import ChessBoard.Board;
import ChessBoard.BoardCell;
import ChessCommon.Colour;
import static ChessPiece.QueenTest.cells;
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
public class BishopTest {
    
    static BoardCell [] [] cells ;
    private Board board;
    
    public BishopTest() {
    }
 
    @Before
    public void setUp() {
        this.board = new Board();
        board.setup();
        cells = board.getCells();
        //added extra piece to make space for bishop to move
        cells [6] [3] = new BoardCell(6,3, null);
        //cells [6] [1] = new BoardCell(6,1, null);
    }
    
    /**
     * Test of allowedMove method, of class Bishop.
     */
    @Test
    public void testAllowedMoveLegal() {
        System.out.println("allowedMove leagal diagonal right");
        BoardCell initialPos = board.getCell(7, 2);
        BoardCell finalPos = board.getCell(4, 5);
        Bishop instance = new Bishop(Colour.White);
        int expResult = 0;
        int result = instance.allowedMove(board, initialPos, finalPos);
        assertEquals(expResult, result);
    } 
      
    /**
     * Test of toString method, of class Bishop. toString
     */
    @Test
    public void testAllowedMoveIllegalOnOwnColour() {
        System.out.println("allowedMove illegal forwards");
        BoardCell initialPos = board.getCell(7, 2);;
        BoardCell finalPos = board.getCell(6, 1);;
        Bishop instance = new Bishop(Colour.White);
        int expResult = -1;
        int result = instance.allowedMove(board, initialPos, finalPos);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of allowedMove method, of class Bishop.
     */
    @Test
    public void testAllowedMoveIlLegal() {
        System.out.println("allowedMove illegal forwards");
        BoardCell initialPos = board.getCell(7, 2);;
        BoardCell finalPos = board.getCell(4, 2);;
        Bishop instance = new Bishop(Colour.White);
        int expResult = -1;
        int result = instance.allowedMove(board, initialPos, finalPos);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Bishop. toString
     */
    @Test
    public void testToStringWhite() {
        System.out.println("Bishop toString White");
        Bishop instance = new Bishop(Colour.White);
        String expResult = "White Bishop";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
  
    /**
     * Test of toString method, of class Bishop. toString
     */
    @Test
    public void testToStringBlack() {
        System.out.println("Bishop toString White");
        Bishop instance = new Bishop(Colour.Black);
        String expResult = "Black Bishop";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
