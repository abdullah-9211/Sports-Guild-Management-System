package com.example.i200444_i200518_project;

public class view_attendanceTable {
    private String date;
    private String present;

    public view_attendanceTable(String date, String present) {
        this.date = date;
        this.present = present;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }
}
