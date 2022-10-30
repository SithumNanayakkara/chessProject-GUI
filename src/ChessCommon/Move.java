package ChessCommon;

import ChessBoard.BoardCell;
import ChessPiece.Piece;
import java.util.List;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class Move 
{
    private BoardCell initialC;
    private BoardCell finalC;
    private Piece killedPiece;
    private Piece movedPiece;
   

    public Move(BoardCell initialC, BoardCell finalC) 
    {
        this.initialC = initialC;
        this.finalC = finalC;
    }

    public BoardCell getInitialC() {
        return initialC;
    }

    public void setInitialC(BoardCell initialC) {
        this.initialC = initialC;
    }

    public BoardCell getFinalC() {
        return finalC;
    }

    public void setFinalC(BoardCell finalC) {
        this.finalC = finalC;
    }

    public Piece getKilledPiece() {
        return killedPiece;
    }

    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }

    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

   
    
    
 
}
 