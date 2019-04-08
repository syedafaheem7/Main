package com.example.db;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateList extends Fragment {
    private EditText listID, listName;
    private Button BnSave;



    public CreateList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_list, container, false);

        listID = view.findViewById(R.id.txt_listID);
        listName = view.findViewById(R.id.txt_listName);
        BnSave = view.findViewById(R.id.bn_save_list);

        BnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int listid = Integer.parseInt(listID.getText().toString());
                String listname = listName.getText().toString();

                GroceryList list = new GroceryList();
                list.setListID(listid);
                list.setListName(listname);

                MainActivity.myAppDatabase.myDao().createList(list);
                Toast.makeText(getActivity(),"The list is  added",Toast.LENGTH_SHORT).show();

                listID.setText("");
                listName.setText("");
            }
        });

        return view;
    }

}
