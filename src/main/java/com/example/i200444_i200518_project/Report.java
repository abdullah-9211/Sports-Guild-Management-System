package com.example.i200444_i200518_project;

import java.util.ArrayList;

public class Report {
    private String month;
    private String year;
    private String teamName;
    private Integer fixtures_held;
    private Integer fixtures_won;
    private Double win_percentage;

    private Double attendance_percentage;

    public Report(Integer month, String year, String teamName, Integer fixtures_held, Integer fixtures_won, ArrayList<String> attendance) {
        this.month = this.monthNumToString(month);
        this.year = year;
        this.teamName = teamName;
        this.fixtures_held = fixtures_held;
        this.fixtures_won = fixtures_won;
        this.win_percentage = (double) (fixtures_won) / fixtures_held;
        int num_attended = 0;
        for(int i = 0; i < attendance.size(); i++) {
            if(attendance.get(i).equals("True")) {
                num_attended += 1;
            }
        }
        this.attendance_percentage = (double) (num_attended) / attendance.size();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getFixtures_held() {
        return fixtures_held;
    }

    public void setFixtures_held(Integer fixtures_held) {
        this.fixtures_held = fixtures_held;
    }

    public Integer getFixtures_won() {
        return fixtures_won;
    }

    public void setFixtures_won(Integer fixtures_won) {
        this.fixtures_won = fixtures_won;
    }

    public Double getWin_percentage() {
        return win_percentage;
    }

    public void setWin_percentage(Double win_percentage) {
        this.win_percentage = win_percentage;
    }

    public Double getAttendance_percentage() {
        return attendance_percentage;
    }

    public void setAttendance_percentage(Double attendance_percentage) {
        this.attendance_percentage = attendance_percentage;
    }

    public String monthNumToString(Integer monthNum){
        switch (monthNum){
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "Invalid Month";
        }
    }
}
