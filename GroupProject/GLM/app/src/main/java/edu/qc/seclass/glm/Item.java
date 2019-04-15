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
        quantity = 1;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void changeQuantity(int n){
        quantity = n;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        this.isChecked = checked;
    }


    public int getQuantity() {
        return  quantity;
    }

    public void setQuantity(int n) {
        this.quantity = n;
    }
}
