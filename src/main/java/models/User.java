package models;

public class User {
    private int userID;
    private UserRole role;
    private String username;
    private String password;
    private String first;
    private String last;
    private String email;

    public User() {
    }

    public User(String username, String password, String first, String last, String email) {
        this.username = username;
        this.password = password;
        this.first = first;
        this.last = last;
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

