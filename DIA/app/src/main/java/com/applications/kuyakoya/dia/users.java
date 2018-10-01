package com.applications.kuyakoya.dia;

public class users {
    String userID;
    String username;
    String password;

    public users(){
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    public users(String userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}