package edu.qc.seclass.glm;

//import android.support.design.widget.FloatingActionButton;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listOfLists);

        ListOfLists mainList = new ListOfLists();
        mainList.add(new GroceryList("Sample Grocery List 1selakhfjrhgjdfaf;as;hfdkahljfz;gbjzl"));
        mainList.add(new GroceryList("Sample Grocery List 2"));
        mainList.add(new GroceryList("Sample Grocery List 3"));
        mainList.add(new GroceryList("Sample Grocery List 4"));
        mainList.add(new GroceryList("Sample Grocery List 5"));
        mainList.add(new GroceryList("Sample Grocery List 6"));
        mainList.add(new GroceryList("Sample Grocery List 7"));
        mainList.add(new GroceryList("Sample Grocery List 8"));

        GListViewAdapter myAdapter = new GListViewAdapter(this,R.layout.g_list_view_items, mainList);
        listView.setAdapter(myAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openGList();
            }
        });


        FloatingActionButton floatingActionButton= findViewById(R.id.addItemButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
              //     openNameList();
                    Toast.makeText(MainActivity.this, "Add Grocery List!", Toast.LENGTH_SHORT).show();
                }
        });
    }
    public void openGList(){
        Intent intent =  new Intent(this, gListActivity.class);
        startActivity(intent);
    }


//    public void openNameList(){
//        Intent intent =  new Intent(this, gListActivity.class);
//        startActivity(intent);
//    }
//

//        FloatingActionButton floatingActionButton= findViewById(R.id.addItemButton);
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(MainActivity.this, "Add Item!", Toast.LENGTH_SHORT).show();
//                }
//        });
    }
