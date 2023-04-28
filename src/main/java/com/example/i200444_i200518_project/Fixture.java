package com.example.i200444_i200518_project;


public class Fixture {
    private String homeTeam;
    private String awayTeam;
    private String venue;
    private String date;
    private String sport;

    public Fixture(){
        homeTeam = "";
        awayTeam = "";
        venue = "";
        date = "";
        sport = "";
    }

    public Fixture(String homeTeam, String awayTeam, String venue, String date, String sport) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.venue = venue;
        this.date = date;
        this.sport = sport;
    }


    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
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

    public boolean initiateAdd() {
        DBHelper dbHelper = new DBHelper();
        return dbHelper.addFixture(this);
    }
}
