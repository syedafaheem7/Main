package com.example.db;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textservice.TextInfo;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.

 */
public class Select extends Fragment {
    private TextView textInfo;

    public Select() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select, container, false);
        textInfo = view.findViewById(R.id.txt_display);

        List<GroceryList> list = MainActivity.myAppDatabase.myDao().getUsers();

        String info ="";

        for(GroceryList lists: list){
            int listID = lists.getListID();
            String listName = lists.getListName();

            info = info + "\n\n" + "List ID: " + listID
                    + "\n List Name: " + listName;
        }

        textInfo.setText(info);

        return view;
    }
}