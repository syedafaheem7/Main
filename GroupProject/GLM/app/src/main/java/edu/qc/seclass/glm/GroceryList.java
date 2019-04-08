package edu.qc.seclass.glm;

import java.util.ArrayList;

public class GroceryList extends ArrayList<Item>{
    String listName;

    public GroceryList(String n){
        super();
        listName = n;
    }

    public String getName(){
        return listName;
    }

    public void renameList(String n){
        listName = n;
    }

    public void clearAllChecks(){}

    public void removeItem(Item itm){
        this.remove(itm);
    }

    public void addItem(Item itm){
        this.add(itm);
    }

    public void clearCompleted(){}


}
