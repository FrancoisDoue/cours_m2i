package org.exercice.entity;

public class Account {
    private String mail;
    private String username;
    private String password;
    private boolean isLogged;

    public Account(String mail, String username, String password) {
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.isLogged = false;
    }
    public Account() {}

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

}
