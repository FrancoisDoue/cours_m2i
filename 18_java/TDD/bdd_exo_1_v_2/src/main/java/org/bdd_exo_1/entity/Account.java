package org.bdd_exo_1.entity;

public class Account {
    private int id;
    private String email;
    private String username;
    private String password;
    boolean isLogged;

    public Account() {}

    public Account(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.isLogged = false;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
