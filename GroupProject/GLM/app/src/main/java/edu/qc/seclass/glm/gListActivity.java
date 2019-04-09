package edu.qc.seclass.glm;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class gListActivity extends AppCompatActivity {

    ListView groceryListView;
    GroceryList gList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_list);

        Intent intent = getIntent();
        //gList = intent.getParcelableArrayListExtra("Grocery List");

        groceryListView = findViewById(R.id.GroceryList);

        final GroceryListArrayAdapter myAdapter = new GroceryListArrayAdapter(this,R.layout.grocery_list_items_view, gList);
        groceryListView.setAdapter(myAdapter);
        groceryListView.setClickable(true);

        FloatingActionButton floatingActionButton= findViewById(R.id.addItemButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                addList(myAdapter);
//                myAdapter.notifyDataSetChanged();
            }
        });
   // }
    }
}
