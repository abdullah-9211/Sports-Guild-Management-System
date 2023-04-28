package com.example.i200444_i200518_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AdminDashboard {
    private Stage stage;
    private Scene scene;
    private Parent root;

    Admin current_admin;
    @FXML
    private Button logout_button;

    @FXML
    private Button profile_button;

    @FXML
    private Button reg_admin_btn;

    @FXML
    private Button reg_cap_btn;

    @FXML
    private Button reg_ec_btn;

    @FXML
    private Button reg_member_btn;

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

    @FXML
    void initialize(){
        UserHolder holder = UserHolder.getInstance();
        current_admin = (Admin) holder.getUser();
        side_name.setText(current_admin.getUsername());
        user_name.setText(current_admin.getUsername());
        user_phone.setText(current_admin.getCnic());
        user_rollnum.setText(current_admin.getRoll_num());
        user_desc.setText("Administrator");
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
    void gotoProfile(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile.fxml")));
            view_pane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void registerAdmin(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
            view_pane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void registerMember(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add-member.fxml")));
            view_pane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void register_captain(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add-captain.fxml")));
            view_pane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void register_ec(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add-executive.fxml")));
            view_pane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
