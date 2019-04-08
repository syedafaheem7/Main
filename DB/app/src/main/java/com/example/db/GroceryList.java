package com.example.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "GroceryList")
public class GroceryList {
    @PrimaryKey
    private int listID;

    private String listName;

   // private ArrayList<Item> list = new ArrayList<Item>();

    // public void addItem(Item item, GroceryList groceryList){}

    public int getListID() {
        return listID;
    }

    public void setListID(int listID) {
        this.listID = listID;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}

