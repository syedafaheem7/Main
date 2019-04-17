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
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
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


        // set menu bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setCustomView(R.layout.action_bar);
        actionBar.setDisplayOptions(R.layout.action_bar);
        actionBar.setHomeButtonEnabled(true);

        // upload from db
        db = new dbHelper(this);
        mainList = db.getData();
        Intent intent = getIntent();
//        gList = intent.getParcelableExtra("Glist");
        position = intent.getIntExtra("Position", 0);
        gList = mainList.get(position);
        setTitle(gList.listName);


        // get checkable
       final ListView groceryListView = (ListView)findViewById(R.id.GroceryList);

        final GroceryListArrayAdapter myAdapter = new GroceryListArrayAdapter(this, gList);
        groceryListView.setAdapter(myAdapter);
        groceryListView.setClickable(true);
            myAdapter.notifyDataSetChanged();


        // When list view item is clicked.
        groceryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int itemIndex, long l) {
                Object itemObject = adapterView.getAdapter().getItem(itemIndex);
                // Translate the selected item to DTO object.
                Item itemD = (Item)itemObject;

                // Get the checkbox.
                CheckBox itemCheckbox = (CheckBox) view.findViewById(R.id.chk_box);

                // Reverse the checkbox and clicked item check state.
                if(itemCheckbox.isChecked())
                {
                    itemCheckbox.setChecked(false);
                    gList.get(itemIndex).setChecked(false);
                    //itemD.setChecked(false);
                }else
                {
                    itemCheckbox.setChecked(true);
                    gList.get(itemIndex).setChecked(true);
                    //itemD.setChecked(true);
                }
                myAdapter.notifyDataSetChanged();

                Toast.makeText(getApplicationContext(), "select item text : " + itemD.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton floatingActionButton= findViewById(R.id.addItemButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(myAdapter);
                myAdapter.notifyDataSetChanged();
            }
        });


        final CheckBox mCheckbox = (CheckBox) actionBar.getCustomView().findViewById(R.id.check_all);
        mCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    for(Item i: gList){
                        i.isChecked= true;
                        groceryListView.setItemChecked(myAdapter.getPosition(i), true);
                        i.setChecked(true);
                    }
                    myAdapter.notifyDataSetChanged();
                }
                if (!isChecked){
                    for(Item i: gList){
                        i.isChecked= false;
                        groceryListView.setItemChecked(myAdapter.getPosition(i), false);
                        i.setChecked(false);
                    }
                    myAdapter.notifyDataSetChanged();
                }
            }
        });

        FloatingActionButton delete= findViewById(R.id.deleteItemButton);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeList(myAdapter, mCheckbox);
                myAdapter.notifyDataSetChanged();
            }
        });
    }

    public void addItem(final GroceryListArrayAdapter myAdapter) {
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.add_item_prompt, null);

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);
        final Spinner itemTypeSpinner = promptsView.findViewById(R.id.nameTypeInput);
        final ArrayList<String> itemTypes = db.getItems();
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, itemTypes);

        itemTypeSpinner.setAdapter(adapter);

        final TextView ItemTypeInputLabel = promptsView.findViewById(R.id.writeItemTypeLabel);

        final EditText itemTypeInput = promptsView.findViewById(R.id.WriteItemType);

        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.nameInput);

        final EditText quantity = (EditText) promptsView
                .findViewById(R.id.quantityInput);


        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                String type;
                                if(itemTypeInput.getVisibility() == View.VISIBLE){
                                    type = itemTypeInput.getText().toString();
                                    db.insertItem(type);
                                }
                                else{
                                    type = itemTypeSpinner.getSelectedItem().toString();
                                }
//                                if (itemTypeInput.getText().toString() == "")
//                                    type = itemTypeSpinner.getSelectedItem().toString();
//                                else {
//                                    type = itemTypeInput.getText().toString();
//                                    db.insertItem(type);
//                                }
                                Item item = new Item(type, userInput.getText().toString());
                                String quantityStirng = quantity.getText().toString();
                                item.setQuantity(Integer.parseInt(quantityStirng));
                                myAdapter.add(item);
                                mainList.removeGroceryList(position);
                                mainList.add(position, gList);
                                db.update(mainList);

                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        final AlertDialog alertDialog = alertDialogBuilder.create();

        itemTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(itemTypes.get(position).contentEquals("Other")) {
                    itemTypeInput.setVisibility(View.VISIBLE);
                    ItemTypeInputLabel.setVisibility(View.VISIBLE);
                }
                else{
                    ItemTypeInputLabel.setVisibility(View.INVISIBLE);
                    itemTypeInput.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        quantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!isInteger(quantity.getText().toString()) || Integer.parseInt(quantity.getText().toString()) < 0) {
                    Toast.makeText(context, "Quantity must be a positive integer", Toast.LENGTH_SHORT).show();
                    ((AlertDialog) alertDialog).getButton(AlertDialog.BUTTON_POSITIVE)
                            .setEnabled(false);
                } else ((AlertDialog) alertDialog).getButton(AlertDialog.BUTTON_POSITIVE)
                        .setEnabled(true);
            }

            public void afterTextChanged(Editable s) {

            }
        });

        userInput.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (gList.contains(userInput.getText().toString()) || userInput.getText().length() == 0) {
                    Toast.makeText(context, "This Item Already Exists", Toast.LENGTH_SHORT).show();
                    ((AlertDialog) alertDialog).getButton(AlertDialog.BUTTON_POSITIVE)
                            .setEnabled(false);
                }
                else ((AlertDialog) alertDialog).getButton(AlertDialog.BUTTON_POSITIVE)
                        .setEnabled(true);
            }

            public void afterTextChanged(Editable s) {

            }
        });



        // show it
        alertDialog.show();
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
    }

    public static boolean isInteger(String s) {
        boolean isValidInteger = false;
        try {
            Integer.parseInt(s);

            // s is a valid integer

            isValidInteger = true;
        } catch (NumberFormatException ex) {
            // s is not an integer
        }

        return isValidInteger;
    }


    public void removeList(final GroceryListArrayAdapter myAdapter, final CheckBox checkBox){
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
                                checkBox.setChecked(false);
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
