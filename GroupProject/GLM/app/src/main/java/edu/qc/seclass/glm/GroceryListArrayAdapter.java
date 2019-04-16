package edu.qc.seclass.glm;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GroceryListArrayAdapter extends ArrayAdapter<Item> {

    ArrayList<Item> items = new ArrayList<>();
    Context context;

    public GroceryListArrayAdapter(Context context, GroceryList items) {
        super(context, R.layout.grocery_list_items_view, items);
        context = context;
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
        }
            convertView = View.inflate(getContext(), R.layout.grocery_list_items_view, null);

            CheckBox listItemCheckbox = (CheckBox) convertView.findViewById(R.id.chk_box);

            TextView quantity = (TextView) convertView.findViewById(R.id.quantity);

            final ImageView elipses = (ImageView) convertView.findViewById(R.id.more);


            TextView listItemText = (TextView) convertView.findViewById(R.id.textView);

            viewHolder = new ViewItemHolder(convertView);

            viewHolder.setItemCheckbox(listItemCheckbox);

            viewHolder.setItemQuantity(quantity);

            viewHolder.setItemTextView(listItemText);

            convertView.setTag(viewHolder);


        final Item item = items.get(position);
        viewHolder.getItemCheckbox().setChecked(item.isChecked());
        viewHolder.getItemTextView().setText(item.getName());
        viewHolder.getItemQuantity().setText(String.valueOf(item.getQuantity()));

        listItemCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setChecked(!item.isChecked);
            }
        });


        elipses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pm = new PopupMenu(getContext(), elipses);
                pm.getMenuInflater().inflate(R.menu.more, pm.getMenu());
                pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                       switch (item.getItemId()){
                           case R.id.changeQuant:
                               Log.d("quant", "quant");

                           case R.id.removePopUp:
                               Log.d("remove", "remove");
                       }
                        return true;
                    }
                });
                pm.show();
            }
        });


        return convertView;
    }
}
