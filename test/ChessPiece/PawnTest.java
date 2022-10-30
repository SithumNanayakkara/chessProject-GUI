/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessPiece;

import ChessPiece.Pawn;
import ChessBoard.Board;
import ChessBoard.BoardCell;
import ChessCommon.Colour;
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
public class PawnTest {
    
    static BoardCell [] [] cells ;
    private Board board;
   
    @Before
    public void setUp() {
        this.board = new Board();
        board.setup();
        cells = board.getCells();
        //added extra piece to test killing functionality
        cells [5] [5] = new BoardCell(5,5, new Pawn(Colour.Black));
    }

    /**
     * Test of allowedMove method, of class Pawn. When the pawn moves one blocks forward
     */
    @Test
    public void testAllowedMove1cell () {
        System.out.println("Pawn allowedMove forward 1 block");
        BoardCell initialPos = board.getCell(1, 0);
        BoardCell finalPos = board.getCell(2, 0);
        Pawn instance = new Pawn (Colour.Black);
        int expResult = 1;
        int result = instance.allowedMove(board, initialPos, finalPos);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of allowedMove method, of class Pawn. When the pawn moves two blocks forward
     */
    @Test
    public void testAllowedMove2cells () {
        System.out.println("Pawn allowedMove forward 2 blocks");
        BoardCell initialPos = board.getCell(1, 3);
        BoardCell finalPos = board.getCell(3, 3);
        Pawn instance = new Pawn (Colour.Black);
        int expResult = 0;
        int result = instance.allowedMove(board, initialPos, finalPos);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of allowedMove method, of class Pawn. When an legal move is performed
     */
    @Test
    public void testAllowedMoveLegalKill () {
        System.out.println("Pawn allowedMove is legal, killing enemy piece sideways");
        BoardCell initialPos = board.getCell(6, 4);
        BoardCell finalPos = board.getCell(5, 5);
        Pawn instance = new Pawn (Colour.White);
        int expResult = 1;
        int result = instance.allowedMove(board, initialPos, finalPos);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of allowedMove method, of class Pawn. When an illegal move is performed (killing own piece)
     */
    @Test
    public void testAllowedMoveIllegalOnOwnColour () {
        System.out.println("Pawn allowedMove is illegal, moving ontop of own colour");
        BoardCell initialPos = board.getCell(1, 5);
        BoardCell finalPos = board.getCell(1, 4);
        Pawn instance = new Pawn (Colour.Black);
        int expResult = -1;
        int result = instance.allowedMove(board, initialPos, finalPos);
        assertEquals(expResult, result);
    }
    
    
    /**
    * Test of allowedMove method, of class Pawn. When an illegal move is performed (killing across the board)
    */
    @Test
    public void testAllowedMoveIllegalKill () {
        System.out.println("Pawn allowedMove is illegal, killing enemy piece across the board");
        BoardCell initialPos = board.getCell(1, 5);
        BoardCell finalPos = board.getCell(6, 5);
        Pawn instance = new Pawn (Colour.Black);
        int expResult = -1;
        int result = instance.allowedMove(board, initialPos, finalPos);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Pawn. Checking the to String method for white Pawn
     */
    @Test
    public void testToStringWhite() {
        System.out.println("Pawn toString White");
        Pawn instance = new Pawn (Colour.White);
        String expResult = "White Pawn";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class Pawn. Checking the to String method for black pawn
     */
    @Test
    public void testToStringBlack() {
        System.out.println("Pawn toString White");
        Pawn instance = new Pawn (Colour.Black);
        String expResult = "Black Pawn";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
