package com.example.i200444_i200518_project;

public class Admin extends User{

    public Admin() {
    }

    public Admin(String username, String cnic, String password, String roll_num, String type) {
        super(username, cnic, password, roll_num, type);
    }

    public Admin(String username, String password) {
        super(username, password);
    }

    public static Admin getAdmin(String user_name){
        DBHelper dbHelper = new DBHelper();
        return dbHelper.getAdmin(user_name);
    }

    public boolean initiateAdd() {
        DBHelper dbHelper = new DBHelper();
        return dbHelper.addAdmin(this);
    }
}
