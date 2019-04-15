package edu.qc.seclass.glm;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Iterator;

import edu.qc.seclass.glm.dbHelper;

public class gListActivity extends AppCompatActivity {

    ListView groceryListView;
    GroceryList gList;
    dbHelper db;
    ListOfLists mainList;
    int position;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_list);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setCustomView(R.layout.action_bar);
        actionBar.setDisplayOptions(R.layout.action_bar);
        actionBar.setHomeButtonEnabled(true);
        db = new dbHelper(this);
        mainList = db.getData();
        for(GroceryList gl:mainList)Log.d("List", gl.getName());
        Intent intent = getIntent();
//        gList = intent.getParcelableExtra("Glist");
        position = intent.getIntExtra("Position", 0);
        gList = mainList.get(position);
        setTitle(gList.listName);

//        if((savedInstanceState != null) &&
//                (savedInstanceState.getSerializable(gList.getName()) != null)){
//            gList = (GroceryList) savedInstanceState.getSerializable(gList.getName());
//        }

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

        FloatingActionButton delete= findViewById(R.id.deleteItemButton);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeList(myAdapter);
                myAdapter.notifyDataSetChanged();

            }
        });

        CheckBox mCheckbox = (CheckBox) actionBar.getCustomView().findViewById(R.id.check_all);
        mCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    for(Item i: gList){
                        i.isChecked= true;
                        groceryListView.setItemChecked(myAdapter.getPosition(i), true);
                        myAdapter.notifyDataSetChanged();


                    }
                }
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
                                mainList.removeGroceryList(position);
                                mainList.add(position, gList);
                                db.update(mainList);

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


    public void removeList(final GroceryListArrayAdapter myAdapter){
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.remove_item_prompt, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                for (Iterator<Item> iterator = gList.iterator(); iterator.hasNext(); ) {
                                    Item value = iterator.next();
                                    if (value.isChecked == true) {
                                        iterator.remove();
                                        myAdapter.notifyDataSetChanged();
                                    }
                                }
                                mainList.removeGroceryList(position);
                                mainList.add(position, gList);
                                db.update(mainList);
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

}
