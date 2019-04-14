package edu.qc.seclass.glm;

//import android.support.design.widget.FloatingActionButton;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private dbHelper db;
    ListOfLists mainList;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.listOfLists);
        db = new dbHelper(context);
        mainList = db.getData();
        if(mainList == null) mainList = new ListOfLists();

        final ListOfListArrayAdapter listofListstoViewAdapter= new ListOfListArrayAdapter(context, mainList);
        gridView.setAdapter(listofListstoViewAdapter);
//        gridView.setClickable(true);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openGList(position);
            }
        });

        FloatingActionButton dbfloatingActionButton= findViewById(R.id.showDB);
        dbfloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dbmanager = new Intent(context, AndroidDatabaseManager.class);
                startActivity(dbmanager);
            }
        });


        FloatingActionButton floatingActionButton= findViewById(R.id.addItemButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addList(listofListstoViewAdapter);
                    listofListstoViewAdapter.notifyDataSetChanged();

                }
        });

        FloatingActionButton fab= findViewById(R.id.deleteItemButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }



    public void openGList(int position){
        Intent intent =  new Intent(this, gListActivity.class);
//        intent.putExtra("Glist", (Parcelable) mainList.get(position));
        intent.putExtra("Position", position);
        startActivity(intent);
    }

    public void addList(final ListOfListArrayAdapter myAdapter){
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
                                GroceryList temp = new GroceryList(userInput.getText().toString());
//                                temp.addItem(new Item("Type", "Item"));
                                myAdapter.add(temp);
                                if(mainList.size() == 1) db.insertData(mainList);
                                else db.update(mainList);
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
