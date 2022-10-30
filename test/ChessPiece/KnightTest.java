/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessPiece;

import ChessPiece.Knight;
import ChessPiece.Pawn;
import ChessBoard.Board;
import ChessBoard.BoardCell;
import ChessCommon.Colour;
import static ChessPiece.PawnTest.cells;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class KnightTest {
    
    static BoardCell [] [] cells ;
    private Board board;
    
    public KnightTest() {
    }
    
    @Before
    public void setUp() {
        this.board = new Board();
        board.setup();
        cells = board.getCells();
        //added extra piece to test killing functionality
        cells [5] [5] = new BoardCell(5,5, new Pawn(Colour.Black));
    }
    
    /**
     * Test of allowedMove method, of class Knight. When the Knight jumps over the pawns and follow L shape
     */
    @Test
    public void testAllowedMove1cell () {
        System.out.println("Knight allowedMove in L shape");
        BoardCell initialPos = board.getCell(0, 6);
        BoardCell finalPos = board.getCell(2, 5);
        Knight instance = new Knight (Colour.Black);
        int expResult = 1;
        int result = instance.allowedMove(board, initialPos, finalPos);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of allowedMove method, of class Knight. When an illegal move is performed (killing own piece)
     */
    @Test
    public void testAllowedMoveIllegalOnOwnColour () {
        System.out.println("Knight allowedMove is illegal, moving ontop of own colour");
        BoardCell initialPos = board.getCell(7, 6);
        BoardCell finalPos = board.getCell(6, 4);
        Knight instance = new Knight (Colour.White);
        int expResult = -1;
        int result = instance.allowedMove(board, initialPos, finalPos);
        assertEquals(expResult, result);
    }
   

    /**
     * Test of toString method, of class Knight. Checking the to String method for white Knight
     */
    @Test
    public void testToStringWhite() {
        System.out.println("Knight toString White");
        Knight instance = new Knight (Colour.White);
        String expResult = "White Knight";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class Knight. Checking the to String method for black Knight
     */
    @Test
    public void testToStringBlack() {
        System.out.println("Knight toString Black");
        Knight instance = new Knight (Colour.Black);
        String expResult = "Black Knight";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
