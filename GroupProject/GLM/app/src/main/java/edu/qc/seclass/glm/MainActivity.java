package edu.qc.seclass.glm;

//import android.support.design.widget.FloatingActionButton;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private ListOfListArrayAdapter ListofListstoViewAdapter;
    ListOfLists mainList = new ListOfLists();
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.listOfLists);



        ListofListstoViewAdapter= new ListOfListArrayAdapter(context, mainList);
        gridView.setAdapter(ListofListstoViewAdapter);
//        gridView.setClickable(true);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openGList(position);
            }
        });


        FloatingActionButton floatingActionButton= findViewById(R.id.addItemButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addList(ListofListstoViewAdapter);
                    ListofListstoViewAdapter.notifyDataSetChanged();
                }
        });
    }
    public void openGList(int position){
        Intent intent =  new Intent(this, gListActivity.class);
        intent.putExtra("Grocery List", mainList.get(position));
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
