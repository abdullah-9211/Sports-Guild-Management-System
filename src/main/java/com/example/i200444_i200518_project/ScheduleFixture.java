package com.example.i200444_i200518_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ScheduleFixture {

    @FXML
    private TextField awayteam;

    @FXML
    private Label date;

    @FXML
    private Button date_btn;

    @FXML
    private DatePicker datepicker;

    @FXML
    private TextField hometeam;

    @FXML
    private TextField sport;

    @FXML
    private Button submit_btn;

    @FXML
    private TextField venue;

    Captain curr_cap;
    @FXML
    void execButton(ActionEvent event) {
        UserHolder holder = UserHolder.getInstance();
        curr_cap = (Captain) holder.getUser();
        Fixture fixture = new Fixture(hometeam.getText(), awayteam.getText(), venue.getText(), datepicker.getValue().toString(), curr_cap.getSport());
        if (fixture.initiateAdd()){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Fixture is scheduled!");
            a.show();
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR, "Could not schedule fixture");
            a.show();
        }
    }

    @FXML
    void setDate(ActionEvent event) {
        date.setText(datepicker.getValue().toString());
    }

}
