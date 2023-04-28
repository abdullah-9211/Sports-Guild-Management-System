package com.example.i200444_i200518_project;

import java.sql.Connection;
import java.sql.Statement;

public class User {
    protected String username;
    protected String cnic;
    protected String password;
    protected String roll_num;
    protected String type;

    public User(){
        username = "";
        cnic = "";
        password = "";
        roll_num = "";
        type = "";
    }
    public User(String username, String cnic, String password, String roll_num, String type) {
        this.username = username;
        this.cnic = cnic;
        this.password = password;
        this.roll_num = roll_num;
        this.type = type;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoll_num() {
        return roll_num;
    }

    public void setRoll_num(String roll_num) {
        this.roll_num = roll_num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User initiateLogin() {
        DBHelper dbHelper = new DBHelper();
        User return_user = dbHelper.login(this);
        return return_user;
    }
}
