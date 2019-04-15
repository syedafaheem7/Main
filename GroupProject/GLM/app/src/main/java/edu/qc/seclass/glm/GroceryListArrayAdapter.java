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

    public GroceryListArrayAdapter(Context context, GroceryList items) {
        super(context, R.layout.grocery_list_items_view, items);
        this.items = items;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewItemHolder viewHolder = null;

        if(convertView!=null)
        {
            viewHolder = (ViewItemHolder) convertView.getTag();
        }else
        {
            convertView = View.inflate(getContext(), R.layout.grocery_list_items_view, null);

            CheckBox listItemCheckbox = (CheckBox) convertView.findViewById(R.id.chk_box);

            TextView quantity = (TextView) convertView.findViewById(R.id.quantity);


            TextView listItemText = (TextView) convertView.findViewById(R.id.textView);

            viewHolder = new ViewItemHolder(convertView);

            viewHolder.setItemCheckbox(listItemCheckbox);

            viewHolder.setItemQuantity(quantity);

            viewHolder.setItemTextView(listItemText);

            convertView.setTag(viewHolder);
        }

        Item item = items.get(position);
        viewHolder.getItemCheckbox().setChecked(item.isChecked());
        viewHolder.getItemTextView().setText(item.getName());
        viewHolder.getItemQuantity().setText(String.valueOf(item.getQuantity()));

        return convertView;
    }
}
