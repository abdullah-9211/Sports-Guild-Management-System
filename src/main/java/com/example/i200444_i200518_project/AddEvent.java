package com.example.i200444_i200518_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddEvent {

    @FXML
    private Label date;

    @FXML
    private Button date_btn;

    @FXML
    private DatePicker datepicker;

    @FXML
    private TextField desc;

    @FXML
    private TextField eventName;

    @FXML
    private Button submit_btn;

    @FXML
    private TextField venue;

    @FXML
    void execButton(ActionEvent event) {
        Event scheduleEvent = new Event(datepicker.getValue().toString(), eventName.getText(), venue.getText(), desc.getText());
        if (scheduleEvent.initiateAddition()){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Event added successfully!");
            a.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error while adding event");
            alert.show();
        }
    }

    @FXML
    void getDate(ActionEvent event) {
        date.setText(datepicker.getValue().toString());
    }

}
