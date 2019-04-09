package edu.qc.seclass.glm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GroceryListArrayAdapter extends ArrayAdapter<Item> {

    ArrayList<Item> items = new ArrayList<>();

    public GroceryListArrayAdapter(Context context, int textViewResourceId, ArrayList<Item> items) {
        super(context, textViewResourceId, items);
        this.items = items;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.grocery_list_items_view, null);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        CheckBox checkBoxView = (CheckBox) v.findViewById(R.id.chk_box);
        textView.setText(items.get(position).getName());
        return v;

    }
}
