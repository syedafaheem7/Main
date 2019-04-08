package edu.qc.seclass.glm;
import java.util.ArrayList;


public class ListOfLists extends ArrayList<GroceryList>{

    public ListOfLists(){
        super();
    }

    public void addList(String n){
        GroceryList gl = new GroceryList(n);
        this.add(gl);
    }

    public void removeList(ArrayList<GroceryList> gl){
        this.remove(gl);

    }

    public static void selectList(ArrayList<GroceryList> gl){

    }


}
