package edu.qc.seclass.glm;

public class GroceryList {
    String listName;
    Boolean isChecked;

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public boolean getSelected() {
        return isChecked;
    }

    public void setSelected(boolean selected) {
        isChecked = selected;
    }
}

