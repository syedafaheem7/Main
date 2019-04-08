package com.example.db;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment implements View.OnClickListener {
    private Button BnCreateList,BnRemoveList,BnSelect;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        BnCreateList = view.findViewById(R.id.bn_createList);
        BnCreateList.setOnClickListener(this);

        BnRemoveList = view.findViewById(R.id.bn_removeList);
        BnRemoveList.setOnClickListener(this);

        BnSelect = view.findViewById(R.id.bn_selectList);
        BnSelect.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.bn_createList:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new CreateList()).addToBackStack(null).commit();
                break;

            case R.id.bn_removeList:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new RemoveList()).addToBackStack(null).commit();
                break;

            case R.id.bn_selectList:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new Select()).addToBackStack(null).commit();
                break;
        }
    }
}