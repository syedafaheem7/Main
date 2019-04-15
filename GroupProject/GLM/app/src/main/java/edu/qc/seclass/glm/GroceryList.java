package edu.qc.seclass.glm;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class GroceryList extends ArrayList<Item>{
    String listName;
    boolean isChecked;
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


//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(listName);
//    }
}
