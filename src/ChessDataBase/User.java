package ChessDataBase;

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

    public User(String userName, String Password, String email, int score) {
        this.userName = userName;
        this.Password = Password;
        this.email = email;
        this.score = score;
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
}
