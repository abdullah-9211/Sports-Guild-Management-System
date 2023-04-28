package com.example.i200444_i200518_project;

public class Practice {
    private String day;
    private String time;
    private String sport;

    public Practice(String day, String time, String sport) {
        this.day = day;
        this.time = time;
        this.sport = sport;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public boolean initiateAdd() {
        DBHelper dbHelper = new DBHelper();
        return dbHelper.addPractice(this);
    }
}
