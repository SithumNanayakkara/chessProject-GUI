/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessCommon;

import ChessBoard.Board;
import ChessBoard.BoardCell;
import ChessPiece.King;
import ChessPiece.Pawn;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class ProcessMoveTest {
        
    private Board board;
    
    /**
     * Test of getMoveCells method, of class ProcessMove.
     */
    @Test
    public void testGetMoveCells() {
        System.out.println("getMoveCells");
        ProcessMove instance = new ProcessMove();
        instance.setTurn(1);
        instance.setColour();
        this.board = new Board();
        board.setup();
        int initialRank = 1;
        int initialFile = 1;
        int finalRank = 3;
        int finalFile = 1;
        int expResult = 0;
        int result = instance.getMoveCells(initialRank, initialFile, finalRank, finalFile);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of showWhoMoves method, of class ProcessMove.
     */
    @Test
    public void testShowWhoMoves() {
        System.out.println("showWhoMoves");
        ProcessMove instance = new ProcessMove();
        instance.setTurn(1);
        instance.setColour();
        String expResult = "Black";
        String result = instance.showWhoMoves();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTurn method, of class ProcessMove.
     */
    @Test
    public void testSetTurn() {
        System.out.println("setTurn");
        int turn = 1;
        ProcessMove instance = new ProcessMove();
        instance.setTurn(turn);
    }

    /**
     * Test of getTurn method, of class ProcessMove.
     */
    @Test
    public void testGetTurn() {
        System.out.println("getTurn");
        ProcessMove instance = new ProcessMove();
        int expResult = 0;
        int result = instance.getTurn();
        assertEquals(expResult, result);
    }

    /**
     * Test of setColour method, of class ProcessMove.
     */
    @Test
    public void testSetColour() {
        System.out.println("setColour");
        ProcessMove instance = new ProcessMove();
        instance.setColour();
    }

    /**
     * Test of getColour method, of class ProcessMove.
     */
    @Test
    public void testGetColour() {
        System.out.println("getColour");
        ProcessMove instance = new ProcessMove();
        instance.setTurn(1);
        instance.setColour();
        String expResult = "Black";
        String result = instance.getColour();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInvalidMove method, of class ProcessMove.
     */
    @Test
    public void testGetInvalidMove() {
        System.out.println("getInvalidMove");
        ProcessMove instance = new ProcessMove();
        String expResult = "";
        String result = instance.getInvalidMove();
        assertEquals(expResult, result);
    }

    /**
     * Test of winningCondition method, of class ProcessMove.
     */
    @Test
    public void testWinningCondition() {
        System.out.println("winningCondition");
        ProcessMove instance = new ProcessMove();
        this.board = new Board();
        board.setup();
        instance.setTurn(0);
        instance.setColour();
        boolean expResult = false;
        boolean result = instance.winningCondition();
        assertEquals(expResult, result);
    }

    

    /**
     * Test of doMove method, of class ProcessMove.
     */
    @Test
    public void testDoMove() {
        System.out.println("doMove");
        Move move = new Move(new BoardCell(1,1, new Pawn(Colour.Black)), new BoardCell(2,1, null));
        ProcessMove instance = new ProcessMove();
        this.board = new Board();
        board.setup();
        instance.setTurn(1);
        instance.setColour();
        int expResult = 0;
        int result = instance.doMove(move);
        assertEquals(expResult, result);
    }

    /**
     * Test of processCastling method, of class ProcessMove.
     */
    @Test
    public void testProcessCastling() {
        System.out.println("processCastling");
        Move move = new Move (new BoardCell(0,4, new King(Colour.Black)), new BoardCell(7,6, null));
        ProcessMove instance = new ProcessMove();
        instance.processCastling(move);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isWhite method, of class ProcessMove.
     */
    @Test
    public void testIsWhiteTrue() {
        System.out.println("isWhite True");
        ProcessMove instance = new ProcessMove();
        instance.setTurn(0);
        boolean expResult = true;
        boolean result = instance.isWhite();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isWhite method, of class ProcessMove.
     */
    @Test
    public void testIsWhiteFalse() {
        System.out.println("isWhite False");
        ProcessMove instance = new ProcessMove();
        instance.setTurn(1);
        boolean expResult = false;
        boolean result = instance.isWhite();
        assertEquals(expResult, result);
    }
    
}
