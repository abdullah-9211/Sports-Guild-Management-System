package com.example.i200444_i200518_project;

public class Executive extends User{
    private String post;

    public Executive() {

    }

    public Executive(String username, String cnic, String password, String roll_num, String type, String post) {
        super(username, cnic, password, roll_num, type);
        this.post = post;
    }

    public Executive(String username, String password) {
        super(username, password);
    }

    public static Executive getEC(String username) {
        DBHelper dbHelper = new DBHelper();
        return dbHelper.getEC(username);
    }


    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public boolean initiateAdd() {
        DBHelper dbHelper = new DBHelper();
        return dbHelper.addExec(this);
    }

//    public static Executive getExec(String user_name){
//        //get EC from DB
//    }
}
