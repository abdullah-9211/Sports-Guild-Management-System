package com.example.i200444_i200518_project;

import java.util.ArrayList;

public class Team {
    private String teamName;
    private String sport;
    private ArrayList<String> players;

    public Team(String teamName, String sport, ArrayList<String> players) {
        this.teamName = teamName;
        this.sport = sport;
        this.players = players;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    public ArrayList<String> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<String> players) {
        this.players = players;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public boolean initAddition() {
        DBHelper dbHelper = new DBHelper();
        return dbHelper.addTeam(this);
    }
}
