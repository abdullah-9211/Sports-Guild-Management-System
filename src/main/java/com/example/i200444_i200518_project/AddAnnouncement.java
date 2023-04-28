package com.example.i200444_i200518_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Date;

public class AddAnnouncement {

    @FXML
    private TextField content;

    @FXML
    private TextField subject;

    @FXML
    private Button submit_btn;

    @FXML
    void execButton(ActionEvent event) {
        Date d = new Date();
        Announcement announcement = new Announcement(d.toString(), subject.getText(), content.getText());
        if (announcement.initiateAdd()){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Announcement added successfully!");
            a.show();
        }
        else
        {
            Alert a = new Alert(Alert.AlertType.ERROR, "Error while adding Announcement :(");
            a.show();
        }
    }

}
