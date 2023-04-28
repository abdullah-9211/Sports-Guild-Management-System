package com.example.i200444_i200518_project;

public class Meeting {
    private String date;
    private String time;
    private String venue;
    private String calledBy;
    private String agenda;

    public Meeting(String date, String time, String venue, String calledBy, String agenda) {
        this.date = date;
        this.time = time;
        this.venue = venue;
        this.calledBy = calledBy;
        this.agenda = agenda;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getCalledBy() {
        return calledBy;
    }

    public void setCalledBy(String calledBy) {
        this.calledBy = calledBy;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public boolean initiateAddition() {
        DBHelper dbHelper = new DBHelper();
        return dbHelper.addMeeting(this);
    }
}
