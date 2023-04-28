package com.example.i200444_i200518_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AddMember {
    @FXML
    private TextField username;

    @FXML
    private TextField cnic;

    @FXML
    private TextField rollnum;

    @FXML
    private TextField pass;

    @FXML
    private TextField kit_num;

    @FXML
    private TextField sport;


    public void execButton(ActionEvent actionEvent) {
        int kit = Integer.parseInt(kit_num.getText());
        Member member = new Member(username.getText(), cnic.getText(), pass.getText(), rollnum.getText(), "member", kit, sport.getText());
        if(member.initiateAdd()){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Member added successfully!");
            a.show();
        }
        else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Error while adding member");
            a.show();
        }
    }
}
