package com.example.i200444_i200518_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AddExecutive {
    @FXML
    private TextField username;

    @FXML
    private TextField cnic;

    @FXML
    private TextField rollnum;

    @FXML
    private TextField pass;

    @FXML
    private TextField post;

    public void execButton(ActionEvent actionEvent) {
        Executive exec = new Executive(username.getText(), cnic.getText(), pass.getText(), rollnum.getText(), "ec", post.getText());
        if(exec.initiateAdd()){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "EC Member added successfully!");
            a.show();
        }
        else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Error while adding EC Member");
            a.show();
        }
    }
}
