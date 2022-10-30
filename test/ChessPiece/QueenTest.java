/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessPiece;

import ChessBoard.Board;
import ChessBoard.BoardCell;
import ChessCommon.Colour;
import static ChessPiece.PawnTest.cells;
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
public class QueenTest {
    
    static BoardCell [] [] cells ;
    private Board board;
    
    @Before
    public void setUp() {
        this.board = new Board();
        board.setup();
        cells = board.getCells();
        //removed pieces to test make space for queen to move
        cells [6] [3] = new BoardCell(6,3, null);
        cells [6] [4] = new BoardCell(6,4, null);
    }
    
    /**
     * Test of allowedMove method, of class Queen. Move forward
     */
    @Test
    public void testAllowedMoveFoward() {
        System.out.println("allowedMove forward");
        BoardCell initialPos = board.getCell(7, 3);
        BoardCell finalPos = board.getCell(3, 3);
        Queen instance = new Queen (Colour.White);
        int expResult = 0;
        int result = instance.allowedMove(board, initialPos, finalPos);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of allowedMove method, of class Queen. Move diagonal
     */
    @Test
    public void testAllowedMoveDiagonal() {
        System.out.println("allowedMove diagonal");
        BoardCell initialPos = board.getCell(7, 3);
        BoardCell finalPos = board.getCell(3, 7);
        Queen instance = new Queen (Colour.White);
        int expResult = 0;
        int result = instance.allowedMove(board, initialPos, finalPos);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of allowedMove method, of class Queen. Enemy piece
     */
    @Test
    public void testAllowedMoveLegalKill() {
        System.out.println("allowedMove Kill");
        BoardCell initialPos = board.getCell(7, 3);
        BoardCell finalPos = board.getCell(1, 3);
        Queen instance = new Queen (Colour.White);
        int expResult = 0;
        int result = instance.allowedMove(board, initialPos, finalPos);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of allowedMove method, of class Queen. Enemy piece
     */
    @Test
    public void testAllowedMoveIllegalOnOwnColour () {
        System.out.println("Queen allowedMove is illegal, moving ontop of own colour");
        BoardCell initialPos = board.getCell(7, 3);
        BoardCell finalPos = board.getCell(7, 2);
        Queen instance = new Queen (Colour.White);
        int expResult = -1;
        int result = instance.allowedMove(board, initialPos, finalPos);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Queen.
     */
    @Test
    public void testToStringBlack() {
        System.out.println("Queen toString Black");
        Queen instance = new Queen (Colour.Black);
        String expResult = "Black Queen";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class Queen.
     */
    @Test
    public void testToStringWhite() {
        System.out.println("Queen toString White");
        Queen instance = new Queen (Colour.White);
        String expResult = "White Queen";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
