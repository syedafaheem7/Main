package edu.qc.seclass.glm;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GListViewAdapter extends ArrayAdapter<GroceryList> {

    ArrayList<GroceryList> mainList = new ArrayList<>();

    public GListViewAdapter(Context context, int textViewResourceId, ArrayList<GroceryList> mainList) {
        super(context, textViewResourceId, mainList);
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
        v = inflater.inflate(R.layout.g_list_view_items, null);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
//        CheckBox imageView = (CheckBox) v.findViewById(R.id.chk_box);
        textView.setText(mainList.get(position).getName());
        imageView.setImageResource(R.mipmap.gridimage);
        return v;

    }

}

