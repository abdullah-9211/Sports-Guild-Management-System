package com.example.i200444_i200518_project;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddTeam{
    @FXML
    private TextField teamname;

    @FXML
    private ListView<String> member_list;

    Captain curr_cap;
    ArrayList<String> a = new ArrayList<>();

    @FXML
    void initialize() {
        populateData();
        for (String item : a) {
            member_list.getItems().add(item);
        }
        handleclicks();
    }

    private void handleclicks() {
        member_list.setOnMouseClicked(mouseEvent -> {
            String selectedMember = member_list.getSelectionModel().getSelectedItem().toString();
            Dialog d = new Alert(Alert.AlertType.INFORMATION, selectedMember);
            d.show();
        });
    }

    private void populateData(){
        UserHolder holder = UserHolder.getInstance();
        curr_cap = (Captain)holder.getUser();
        a = DBHelper.getTeamMemberNames(curr_cap.getSport());
    }

    public void execButton(ActionEvent actionEvent) {
        Team team = new Team(teamname.getText(), curr_cap.getSport(), a);
        if (team.initAddition()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Team registered successfully");
            alert.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error while registering team");
            alert.show();
        }
    }


}
