package edu.qc.seclass.glm;

//import android.support.design.widget.FloatingActionButton;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView listView;
    ListOfLists mainList = new ListOfLists();
    final Context context = this;
    private EditText result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listOfLists);


        final GListViewAdapter myAdapter = new GListViewAdapter(this,R.layout.g_list_view_items, mainList);
        listView.setAdapter(myAdapter);
        listView.setClickable(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.print("psarent" + parent+ "view"+ view + "p" + position + "id"+id);
                openGList();
            }
        });


        FloatingActionButton floatingActionButton= findViewById(R.id.addItemButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addList(myAdapter);
                    myAdapter.notifyDataSetChanged();
                }
        });
    }
    public void openGList(){
        Intent intent =  new Intent(this, gListActivity.class);
        startActivity(intent);
    }

    public void addList(final GListViewAdapter myAdapter){
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.g_list_name_prompt, null);

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
                                myAdapter.add(new GroceryList(userInput.getText().toString()));
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
