package com.example.i200444_i200518_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ViewAnnouncements {

    @FXML
    private AnchorPane view_pane;
    @FXML
    private Button add_announcement;

    @FXML
    private ListView<String> content_list;

    @FXML
    private ListView<String> title_list;

    ArrayList<Announcement> announcements;

    @FXML
    void initialize() {
        populateList();
        for (Announcement a : announcements) {
            title_list.getItems().add(a.getTitle());
            content_list.getItems().add(a.getDesc());
        }
    }

    private void populateList() {
        DBHelper dbHelper = new DBHelper();
        announcements = dbHelper.getAnnouncements();
    }

    public void gotoAdd(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add-announcement.fxml")));
            view_pane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}