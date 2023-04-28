package com.example.i200444_i200518_project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class ViewReport implements Initializable {

    @FXML
    private Label avg_attendance;

    @FXML
    private Label date;

    @FXML
    private Label matches_played;

    @FXML
    private Label matches_won;

    @FXML
    private Label team_name;

    @FXML
    private Label win_percentage;

    Captain curr_cap;

    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
        // get current month and year
        Date date = new Date();
        Integer month = date.getMonth() + 1;
        Integer year = date.getYear() + 1900;
        Report report = generateReport(month, year.toString());
        this.date.setText(report.getMonth() + " " + report.getYear());
        this.team_name.setText(report.getTeamName());
        this.matches_played.setText("Held: " + report.getFixtures_held().toString());
        this.matches_won.setText("Won: " + report.getFixtures_won().toString());
        Integer winPerc = (int) (report.getWin_percentage() * 100);
        this.win_percentage.setText(winPerc.toString() + "%");
        Integer attendancePerc = (int) (report.getAttendance_percentage() * 100);
        this.avg_attendance.setText(attendancePerc.toString() + "%");

    }

    public Report generateReport(Integer month, String year) {
        UserHolder holder = UserHolder.getInstance();
        curr_cap = (Captain)holder.getUser();
        Report report;
        Random random = new Random();
        String team_name = curr_cap.getSport();
        ResultSet res = DBHelper.getFixtures(team_name);
        ArrayList<String> attendance = DBHelper.getTeamAttendance(team_name);
        Integer fixtures_held = 0;
        Integer fixtures_won = 0;
        try{
            while(res.next()) {
                fixtures_held += 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Random rand = new Random();
        fixtures_won = rand.nextInt(fixtures_held + 1);
        report = new Report(month, year, team_name, fixtures_held, fixtures_won, attendance);
        return report;
    }

}