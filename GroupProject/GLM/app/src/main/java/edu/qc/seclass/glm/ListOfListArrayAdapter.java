package edu.qc.seclass.glm;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;

public class ListOfListArrayAdapter extends ArrayAdapter<GroceryList> {

    ArrayList<GroceryList> mainList = new ArrayList<>();

    public ListOfListArrayAdapter(Context context, ListOfLists mainList) {
        super(context, R.layout.list_of_lists_items_view,  mainList);
        this.mainList = mainList;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.list_of_lists_items_view, null);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        final  ImageView elipses = (ImageView) v.findViewById(R.id.more);

//        CheckBox imageView = (CheckBox) v.findViewById(R.id.chk_box);
        textView.setText(mainList.get(position).getName());
        imageView.setImageResource(R.mipmap.gridimage);


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
                                Log.d("changeQuant", "quantt");

                            case R.id.removePopUp:
                                Log.d("remove", "remove");
                        }
                        return true;
                    }
                });
                pm.show();
            }
        });

        return v;

    }

}

