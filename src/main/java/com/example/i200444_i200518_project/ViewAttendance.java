package com.example.i200444_i200518_project;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewAttendance implements Initializable {

    @FXML
    private TableView<view_attendanceTable> attendanceTableView;

    @FXML
    private TableColumn<view_attendanceTable, String> isPresentCol;

    @FXML
    private TableColumn<view_attendanceTable, String> practiceDate;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label progressLabel;
    Member curr_member;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserHolder holder = UserHolder.getInstance();
        curr_member = (Member)holder.getUser();
        String roll_number = curr_member.getRoll_num(); //get from previous page
        practiceDate.setCellValueFactory(new PropertyValueFactory<view_attendanceTable, String>("date"));
        isPresentCol.setCellValueFactory(new PropertyValueFactory<view_attendanceTable, String>("present"));
        ArrayList<String> dates = DBHelper.getAttendanceDates(roll_number);
        ArrayList<String> present = DBHelper.getAttendance(roll_number);
        ObservableList<view_attendanceTable> list = attendanceTableView.getItems();
        for (int i = 0; i < dates.size(); i++) {
            list.add(new view_attendanceTable(dates.get(i), present.get(i)));
        }
        // count presents
        int count = 0;
        int total = present.size();
        for (int i = 0; i < present.size(); i++) {
            if (present.get(i).equals("True")) {
                count++;
            }
        }

        if (total == 0){
            progressBar.setProgress(0);
            progressLabel.setText("0%");
        }
        else
        {
            progressBar.setProgress((double) count / total);
            Integer percentage = (count * 100)/total;
            progressLabel.setText(percentage.toString() + "%");
        }
    }
}