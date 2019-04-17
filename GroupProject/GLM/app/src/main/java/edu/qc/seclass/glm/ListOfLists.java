package edu.qc.seclass.glm;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ListOfLists extends ArrayList<GroceryList> {

    public ListOfLists() {
        super();
    }

    public void addList(String n) {
        GroceryList gl = new GroceryList(n);
        this.add(gl);
    }

    public void removeList(ArrayList<GroceryList> gl) {
        this.remove(gl);

    }

    public boolean contains(String name){
        for(GroceryList gl: this) {
            if(gl.getName().contentEquals(name)) return true;
        }
        return false;
    }

    public void removeGroceryList(int gl) {
        this.remove(gl);
    }

    public static void selectList(ArrayList<GroceryList> gl) {

    }
}