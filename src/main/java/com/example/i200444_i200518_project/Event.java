package com.example.i200444_i200518_project;

public class Event {
    private String date;
    private String eventName;
    private String venue;
    private String desc;

    public Event(String date, String eventName, String venue, String desc) {
        this.date = date;
        this.eventName = eventName;
        this.venue = venue;
        this.desc = desc;
    }

    public Boolean addEvent() {
        // TODO: Add event to database
        return true;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean initiateAddition() {
        DBHelper dbHelper = new DBHelper();
        return dbHelper.addEvent(this);
    }
}
