package com.example.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Item")
public class Item {
    @PrimaryKey
    private  int itemID;

    private String itemName;

    private  boolean isChecked = false;

    private  int quantity;

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        itemName = itemName;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
