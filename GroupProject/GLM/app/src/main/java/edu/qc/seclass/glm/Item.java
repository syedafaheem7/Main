package edu.qc.seclass.glm;

public class Item extends ItemType{
    String name;
    boolean isChecked;
    int quantity;

    public Item(String iTypeName, String iName){
        super(iTypeName);
        name = iName;
    }

    public String getName(){
        return name;
    }

    public void changeQuantity(int n){
        quantity = n;
    }

    public void checkItem(){}

}
