package com.example.i200444_i200518_project;

public class Member extends User{
    private int kit_num;
    private String sport;

    public Member() {

    }

    public Member(String username, String cnic, String password, String roll_num, String type, int kit_num, String sport) {
        super(username, cnic, password, roll_num, type);
        this.kit_num = kit_num;
        this.sport = sport;
    }

    public Member(String username, String password) {
        super(username, password);
    }


    public static Member getMember(String user_name){
        DBHelper dbHelper = new DBHelper();
        return dbHelper.getMember(user_name);
    }

    public int getKit_num() {
        return kit_num;
    }

    public void setKit_num(int kit_num) {
        this.kit_num = kit_num;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public boolean initiateAdd() {
        DBHelper dbHelper = new DBHelper();
        return dbHelper.addMember(this);
    }
}
