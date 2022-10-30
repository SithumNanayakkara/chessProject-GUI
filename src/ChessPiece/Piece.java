/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessPiece;

import ChessBoard.Board;
import ChessBoard.BoardCell;
import ChessCommon.Colour;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public abstract class Piece 
{ 
    public boolean isInitialMove;
    private boolean peiceStatus; //shows if the peice is eliminated or not
    private Colour colour; //stores if the colour is black or white
    
    
    public Piece(Colour colour) {
        this.colour = colour;
        this.isInitialMove = true;
    }
    
    public boolean isPeiceStatus() {
        return peiceStatus;
    }  

    public void setPeiceStatus(boolean peiceStatus) {
        this.peiceStatus = peiceStatus;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public boolean isIsInitialMove() {
        return isInitialMove;
    }

    public void setIsInitialMove(boolean isInitialMove) {
        this.isInitialMove = isInitialMove;
    }
       
    public abstract int allowedMove(Board board, BoardCell initialPos, BoardCell finalPos);
        
    @Override
    public abstract String toString();
}  

