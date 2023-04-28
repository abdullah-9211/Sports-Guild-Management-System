package com.example.i200444_i200518_project;

public class Announcement {
    private String date;
    private String title;
    private String desc;

    public Announcement(String date, String title, String desc) {
        this.date = date;
        this.title = title;
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean initiateAdd() {
        DBHelper dbHelper = new DBHelper();
        return dbHelper.addAnnouncement(this);
    }
}
