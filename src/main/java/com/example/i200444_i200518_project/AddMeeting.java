package com.example.i200444_i200518_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddMeeting {

    @FXML
    private TextField agenda;

    @FXML
    private Label date;

    @FXML
    private Button date_btn;

    @FXML
    private DatePicker datepicker;

    @FXML
    private Button submit_btn;

    @FXML
    private TextField time;

    @FXML
    private TextField venue;

    User current_user;

    @FXML
    void execButton(ActionEvent event) {
        UserHolder holder = UserHolder.getInstance();
        current_user = holder.getUser();
        Meeting meeting = new Meeting(datepicker.getValue().toString(), time.getText(), venue.getText(), current_user.getUsername(), agenda.getText());
        if (meeting.initiateAddition()){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Meeting Scheduled Successfully");
            a.show();
        }
        else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Error while scheduling meeting");
            a.show();
        }
    }

    @FXML
    void getDate(ActionEvent event) {
        date.setText(datepicker.getValue().toString());
    }

}
