package edu.qc.seclass.glm;

//import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listOfLists);

        ListOfLists mainList = new ListOfLists();
        mainList.add(new GroceryList("Sample Grocery List 1"));
        mainList.add(new GroceryList("Sample Grocery List 2"));

        GListViewAdapter myAdapter = new GListViewAdapter(this,R.layout.g_list_view_items, mainList);
        listView.setAdapter(myAdapter);

//        final ArrayList<String> addGroceryList = new ArrayList<>();
//
//        addGroceryList.add("Brachs Grocery List");
//        addGroceryList.add("Seasons Grocery List");
//        addGroceryList.add("Gourmet Glatt Grocery List");
//        addGroceryList.add("Trader Joes Grocery List");
//        addGroceryList.add("Supersol Grocery List");
//
//
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, addGroceryList);
//        listView.setAdapter(arrayAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "Selected List: " + addGroceryList.get(position).toString(), Toast.LENGTH_SHORT).show();
//            }
//        });

//        FloatingActionButton floatingActionButton= findViewById(R.id.addItemButton);
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(MainActivity.this, "Add Item!", Toast.LENGTH_SHORT).show();
//                }
//        });
    }
}
