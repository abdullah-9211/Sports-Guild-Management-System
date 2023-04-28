package com.example.i200444_i200518_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class takeAttendance implements Initializable {

    @FXML
    private DatePicker datepicker;
    @FXML
    private Button date_btn;
    @FXML
    private Label date;
    @FXML
    private TableView<attendanceTable> attendance_sheet;

    @FXML
    private TableColumn<attendanceTable, String> player_name;

    @FXML
    private TableColumn<attendanceTable, String> player_roll;

    @FXML
    private TableColumn<attendanceTable, CheckBox> present_check;

    @FXML
    private CheckBox allbtn;

    @FXML
    private Button update_btn;
    Captain current_cap;
    private ArrayList<String> rollnumbers;
    ObservableList<attendanceTable> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserHolder holder = UserHolder.getInstance();
        current_cap = (Captain) holder.getUser();
        String sport = current_cap.getSport(); //get from previous page
        player_name.setCellValueFactory(new PropertyValueFactory<attendanceTable, String>("name"));
        player_roll.setCellValueFactory(new PropertyValueFactory<attendanceTable, String>("roll"));
        present_check.setCellValueFactory(new PropertyValueFactory<attendanceTable, CheckBox>("present"));
        ArrayList<String> playerNames = DBHelper.getTeamMemberNames(sport);
        rollnumbers = DBHelper.getTeamMembers(sport);

        for (int i = 0; i < playerNames.size(); i++) {
            list.add(new attendanceTable(playerNames.get(i), rollnumbers.get(i)));
        }

        attendance_sheet.setItems(list);
    }

    @FXML
    public void allPresent() {
        for (attendanceTable attendanceTable : list) {
            attendanceTable.getPresent().setSelected(true);
        }
    }
    @FXML
    public void updateAttendance(){
        UserHolder holder = UserHolder.getInstance();
        current_cap = (Captain) holder.getUser();
        String sport = current_cap.getSport();
        rollnumbers = DBHelper.getTeamMembers(sport);
        ArrayList<String> attendance = new ArrayList<>();
        // get all selected checkboxes
        for(attendanceTable a : attendance_sheet.getItems()){
            if(a.getPresent().isSelected()){
                attendance.add("True");
                continue;
            }
            attendance.add("False");
        }
        String curr_date = datepicker.getValue().toString();
        Attendance attendance1 = new Attendance(curr_date, sport, rollnumbers, attendance);
        if(!attendance1.storeAttendance()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Attendance not updated");
            alert.showAndWait();
        }
    }

    public void getDate(ActionEvent actionEvent) {
        date.setText(datepicker.getValue().toString() + " " + datepicker.getValue().getDayOfWeek().toString());
    }
}
