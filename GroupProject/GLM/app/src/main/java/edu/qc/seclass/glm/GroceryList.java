package edu.qc.seclass.glm;

import java.util.ArrayList;

public class GroceryList {
    String listName;
    ArrayList<Item> gList;

    public GroceryList(String n, ArrayList<Item> gl ){
        listName = n;
        gList = gl;
    }
}
