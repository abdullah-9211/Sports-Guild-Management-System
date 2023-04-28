package com.example.i200444_i200518_project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Profile {
    @FXML
    private Label user_name;
    @FXML
    private Label user_phone;
    @FXML
    private Label user_rollnum;
    @FXML
    private Label user_desc;

    User current_user;
    @FXML
    void initialize(){
        UserHolder holder = UserHolder.getInstance();
        current_user = holder.getUser();
        user_name.setText(current_user.getUsername());
        user_phone.setText(current_user.getCnic());
        user_rollnum.setText(current_user.getRoll_num());

        if (current_user.getType().equals("admin")){
            user_desc.setText("Administrator");
        } else if (current_user.getType().equals("ec")) {
            Executive e = (Executive)current_user;
            user_desc.setText(e.getPost());
        } else if (current_user.getType().equals("member")) {
            Member m = (Member) current_user;
            user_desc.setText(m.getSport() + " Team Member");
        } else if (current_user.getType().equals("captain")) {
            Captain c = (Captain) current_user;
            user_desc.setText("Captain of " + c.getSport() + " Team");
        }
    }

}
