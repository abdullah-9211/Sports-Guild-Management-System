package com.example.i200444_i200518_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private PasswordField pass;
    @FXML
    private TextField username;

    @FXML
    private Button submit_btn;

    @FXML
    private void execButton(ActionEvent event) {
        User user = new User(username.getText(), pass.getText());
        User user1 = user.initiateLogin();
        if (user1 == null){
            Alert a = new Alert(Alert.AlertType.ERROR, "Invalid Credentials");
            a.show();
        }
        else {
                Admin admin;
                Executive ec;
                Captain cap;
                Member mem;
                UserHolder holder = UserHolder.getInstance();
                if (user1.getType().equals("admin")){
                    admin = Admin.getAdmin(user1.getUsername());
                    holder.setUser(admin);
                }
                if (user1.getType().equals("ec")){
                    ec = Executive.getEC(user1.getUsername());
                    holder.setUser(ec);
                }
                if (user1.getType().equals("captain")){
                    cap = Captain.getCaptain(user1.getUsername());
                    holder.setUser(cap);
                }
                if (user1.getType().equals("member")){
                    mem = Member.getMember(user1.getUsername());
                    holder.setUser(mem);
                }
                try {
                    root = FXMLLoader.load(getClass().getResource(user1.getType() + "-dashboard.fxml"));
                    stage = (Stage) submit_btn.getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

