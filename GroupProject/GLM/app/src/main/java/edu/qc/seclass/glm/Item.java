package edu.qc.seclass.glm;

import java.io.Serializable;

public class Item implements Serializable {
    String typeName;
    String name;
    boolean isChecked;
    int quantity;

    public Item(String iTypeName, String iName){
        name = iName;
        typeName = iTypeName;
    }

    public String getName(){
        return name;
    }

    public void changeQuantity(int n){
        quantity = n;
    }

    public void checkItem(){}

}
