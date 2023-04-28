package com.example.i200444_i200518_project;

import javafx.scene.control.CheckBox;

public class attendanceTable {
    private String name;
    private String roll;
    private CheckBox present;

    public attendanceTable(String name, String roll) {
        this.name = name;
        this.roll = roll;
        this.present = new CheckBox();
    }

    public String getName() {
        return name;
    }

    public String getRoll() {
        return roll;
    }

    public CheckBox getPresent() {
        return present;
    }

    public void setPresent(CheckBox present) {
        this.present = present;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

}

