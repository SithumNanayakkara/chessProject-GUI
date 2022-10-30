package ChessInfo;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class User 
{
    private String userName;
    private String Password;
    private String email;
    private int score;
    private boolean gameLoaded;
    //private boolean whitesTurn;
    private int turn;

    public User(String userName, String Password, String email, int score, boolean gameLoaded, int turn) {
        this.userName = userName;
        this.Password = Password;
        this.email = email;
        this.score = score;
        this.gameLoaded = gameLoaded;
        //this.whitesTurn = whiteTurn;
        this.turn = turn;
    }

    public User(String userName, String Password) {
        this.userName = userName;
        this.Password = Password;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String user) {
        this.userName = user;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String pass) {
        this.Password = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isGameLoaded() {
        return gameLoaded;
    }

    public void setGameLoaded(boolean loadGame) {
        this.gameLoaded = loadGame;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

//    public boolean isWhitesTurn() {
//        return whitesTurn;
//    }
//
//    public void setWhitesTurn(boolean whiteTurn) {
//        this.whitesTurn = whiteTurn;
//    }
}
