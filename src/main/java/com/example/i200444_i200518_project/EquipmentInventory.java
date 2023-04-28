package com.example.i200444_i200518_project;

public class EquipmentInventory {
    private String name;
    private Integer quantity;

    public EquipmentInventory(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean initiateAdd() {
        DBHelper dbHelper = new DBHelper();
        return dbHelper.addEquipment(this);
    }

    public boolean initiateRemove() {
        DBHelper dbHelper = new DBHelper();
        return dbHelper.removeEquipment(this);
    }
}
