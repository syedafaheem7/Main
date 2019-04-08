package edu.qc.seclass.glm;

import java.util.ArrayList;

public class GroceryList {
    String listName;
    ArrayList<Item> gList;

    public GroceryList(String n){
        listName = n;
        ArrayList<Item> gList = new  ArrayList<Item>();
    }
    public ArrayList<Item> getGList(){
        return gList;
    }

    public void renameList(String n){
        listName = n;
    }

    public void clearAllChecks(){}

    public void removeItem(Item itm){
        gList.remove(itm);
    }

    public void addItem(Item itm){
        gList.add(itm);
    }

    public void clearCompleted(){}


}
