package com.example.i200444_i200518_project;

import java.util.ArrayList;

public class Attendance {
    private String date;
    private String sport;
    private ArrayList<String> players;
    private ArrayList<String> attendance;

    public Attendance(String date, String sport, ArrayList<String> players, ArrayList<String> attendance) {
        this.date = date;
        this.sport = sport;
        this.players = players;
        this.attendance = attendance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public ArrayList<String> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<String> players) {
        this.players = players;
    }

    public ArrayList<String> getAttendance() {
        return attendance;
    }

    public void setAttendance(ArrayList<String> attendance) {
        this.attendance = attendance;
    }

    public Boolean storeAttendance(){
        DBHelper dbHelper = new DBHelper();
        return dbHelper.addAttendance(this);
    }
}
