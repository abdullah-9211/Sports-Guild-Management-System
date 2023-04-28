package com.example.i200444_i200518_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField username;
    @FXML
    private TextField pass;
    @FXML
    private TextField cnic;
    @FXML
    private TextField rollnum;

    @FXML
    private Label haveaccount;

    @FXML
    private Button submit_btn;

    @FXML
    private void execButton() {
        Admin add = new Admin(username.getText(), cnic.getText(), pass.getText(), rollnum.getText(), "admin");
        if(add.initiateAdd()){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Admin added successfully!");
            a.show();
        }
        else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Error while adding admin");
            a.show();
        }
    }

}