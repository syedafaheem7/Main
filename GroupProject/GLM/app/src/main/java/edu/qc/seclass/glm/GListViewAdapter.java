package edu.qc.seclass.glm;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GListViewAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<GroceryList> mainList;

    public GListViewAdapter(Activity context, String name, ArrayList<GroceryList> mainList){
        super(context, android.R.layout.simple_list_item_1;
        this.context = context;
        this.mainList = mainList;
    }

    public View getView(View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(android.R.layout.simple_list_item_1, null, true);

        TextView title = (TextView) rowView.findViewById(R.id.)
    }
}
