package com.example.i200444_i200518_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SchedulePractice {

    @FXML
    private Label date;

    @FXML
    private Button date_btn;

    @FXML
    private DatePicker datepicker;

    @FXML
    private TextField time;

    @FXML
    private Button submit_btn;

    Captain curr_cap;
    @FXML
    void execButton(ActionEvent event) {
        UserHolder holder = UserHolder.getInstance();
        curr_cap = (Captain)holder.getUser();
        Practice practice = new Practice(datepicker.getValue().getDayOfWeek().toString(), time.getText(), curr_cap.getSport());
        if (practice.initiateAdd()){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Practice is scheduled!");
            a.show();
        }else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Could not schedule practice");
            a.show();
        }
    }

    @FXML
    void getDate(ActionEvent event) {
        date.setText(datepicker.getValue().toString() + " " + datepicker.getValue().getDayOfWeek().toString());
    }

}
