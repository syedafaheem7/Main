package edu.qc.seclass.glm;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

public class gListActivity extends AppCompatActivity {

    ListView groceryListView;
    GroceryList gList;
    ListOfLists mainList;
    int position;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_list);
        getSupportActionBar().setHomeButtonEnabled(true);




        Intent intent = getIntent();
       gList = intent.getParcelableExtra("Glist");
       // mainList = intent.getParcelableExtra("MainList");
        position = intent.getIntExtra("Position", 0);
        setTitle(gList.listName);

        if((savedInstanceState != null) &&
                (savedInstanceState.getSerializable(gList.getName()) != null)){
            gList = (GroceryList) savedInstanceState.getSerializable(gList.getName());
        }




        groceryListView = findViewById(R.id.GroceryList);

        final GroceryListArrayAdapter myAdapter = new GroceryListArrayAdapter(this, gList);
        groceryListView.setAdapter(myAdapter);
        groceryListView.setClickable(true);

        myAdapter.notifyDataSetChanged();

        FloatingActionButton floatingActionButton= findViewById(R.id.addItemButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addList(myAdapter);
                myAdapter.notifyDataSetChanged();
            }
        });
    }

    public void addList(final GroceryListArrayAdapter myAdapter){
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.add_item_prompt, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.nameInput);

        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                myAdapter.add(new Item("Sample Type", userInput.getText().toString()));
                              //  mainList.get(position).addItem(new Item("Sample Type", userInput.getText().toString()));
                             //   Log.d("NLL", mainList.toString());

                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
    

    protected void onSaveInstanceState(Bundle state){
        super.onSaveInstanceState(state);
        state.putSerializable(gList.getName(), gList);
    }
}
