package com.example.i200444_i200518_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MemberDashboard {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button announcement_button;

    @FXML
    private Button attend_btn;

    @FXML
    private Button logout_button;

    @FXML
    private Button practice_btn;

    @FXML
    private Button profile_button;

    @FXML
    private Label side_name;

    @FXML
    private Label user_desc;

    @FXML
    private Label user_name;

    @FXML
    private Label user_phone;

    @FXML
    private Label user_rollnum;

    @FXML
    private AnchorPane view_pane;

    Member current_member;

    @FXML
    void initialize(){
        UserHolder holder = UserHolder.getInstance();
        current_member = (Member) holder.getUser();
        side_name.setText(current_member.getUsername());
        user_name.setText(current_member.getUsername());
        user_phone.setText(current_member.getCnic());
        user_rollnum.setText(current_member.getRoll_num());
        user_desc.setText(current_member.getSport() + " Team Member");
    }
    @FXML
    void Logout(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
            stage = (Stage) logout_button.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gotoAnnouncements(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view-announcements.fxml")));
            view_pane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gotoProfile(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile.fxml")));
            view_pane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void viewAttendance(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view_attendance.fxml")));
            view_pane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void viewPractice(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view_practice.fxml")));
            view_pane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
