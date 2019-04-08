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
public class RemoveList extends Fragment {
    private EditText listID,listName;
    private Button remove;

    public RemoveList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_remove_list, container, false);
        listID = view.findViewById(R.id.txt_listID);
        listName = view.findViewById(R.id.txt_listName);
        remove = view.findViewById(R.id.bn_removeList);

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                int listid = Integer.parseInt(listID.getText().toString());
                String listname = listName.getText().toString();

                GroceryList list = new GroceryList();
                list.setListID(listid);
                list.setListName(listname);

                MainActivity.myAppDatabase.myDao().removeList(list);
                Toast.makeText(getActivity(),"The list is removed.",Toast.LENGTH_SHORT).show();

                listID.setText("");
                listName.setText("");
            }
        });


        return view;
    }

}
