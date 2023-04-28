package com.example.i200444_i200518_project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class ViewPractice {

    @FXML
    private Label captain;

    @FXML
    private Label days;

    @FXML
    private Label sport;

    @FXML
    private Label time;

    Member curr_mem;

    @FXML
    void initialize(){
        UserHolder holder = UserHolder.getInstance();
        curr_mem = (Member) holder.getUser();

        ArrayList<Practice> practices = DBHelper.getPractices(curr_mem.getSport());
        Captain teamCaptain = DBHelper.getCaptain(curr_mem.getSport());

        captain.setText(teamCaptain.getUsername());
        sport.setText(curr_mem.getSport());
        days.setText("");
        time.setText("");

        for (Practice p : practices){
            days.setText(days.getText() + " | " + p.getDay());
            time.setText(time.getText() + " | " + p.getTime());
        }
    }

}
