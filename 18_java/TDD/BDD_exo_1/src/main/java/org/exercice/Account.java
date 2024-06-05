package org.exercice;

public class Account {
    private String username;
    private String password;
    private boolean isConnect;

    public boolean connect (String username, String password) {
        return isConnect = this.username.equals(username) && this.password.equals(password);
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

    public boolean isConnect() {
        return isConnect;
    }

}
