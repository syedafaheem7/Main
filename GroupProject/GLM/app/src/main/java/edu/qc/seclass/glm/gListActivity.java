package edu.qc.seclass.glm;

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
