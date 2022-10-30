package ChessBoard;

import ChessPiece.Piece;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class BoardCell 
{
    private int xLocation;
    private int yLocation;
    private Piece pieceIs; 

    //constructor to initialises the x,y location and the piece
    public BoardCell(int xLocation, int yLocation, Piece piece) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.pieceIs = piece;
    }
    
    public int getXLocation() {
        return xLocation;
    }

    public void setXLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    public int getYLocation() {
        return yLocation;
    }

    public void setYLocation(int yLocation) {
        this.yLocation = yLocation;
    }

    public Piece getPiece() {
        return pieceIs;
    }

    public void setPiece(Piece piece) {
        this.pieceIs = piece;
    }
    
    //overriden toString for each piece
    @Override
    public String toString() 
    {
        if(pieceIs == null)
        {
            return " 🅇 ";   
        }   
        else
        {
            return pieceIs.toString();
        }
        
    }
}


    
