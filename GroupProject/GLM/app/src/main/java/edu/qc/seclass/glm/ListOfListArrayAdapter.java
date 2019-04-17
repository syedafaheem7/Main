package edu.qc.seclass.glm;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;

public class ListOfListArrayAdapter extends ArrayAdapter<GroceryList> {

    final dbHelper db;
    ListOfLists mainList;

    public ListOfListArrayAdapter(Context context, ListOfLists mainList) {
        super(context, R.layout.list_of_lists_items_view,  mainList);
        this.mainList = mainList;
        db = new dbHelper(getContext());
    }

    @Override
    public int getCount() {
        return super.getCount();
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.list_of_lists_items_view, null);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        final  ImageView elipses = (ImageView) v.findViewById(R.id.more);
        final GroceryList gl = mainList.get(position);

//        CheckBox imageView = (CheckBox) v.findViewById(R.id.chk_box);
        textView.setText(mainList.get(position).getName());
        imageView.setImageResource(R.mipmap.gridimage);


        elipses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pm = new PopupMenu(getContext(), elipses);
                pm.getMenuInflater().inflate(R.menu.lol_more, pm.getMenu());
                pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.rename:
                                renameList(position, gl);
                                break;
                            case R.id.remove:
                                removeList(position, gl);
                        }
                        return true;
                    }
                });
                pm.show();
            }
        });

        return v;

    }


    public void removeList(final int position, final GroceryList gl){
        LayoutInflater li = LayoutInflater.from(getContext());
        View promptsView = li.inflate(R.layout.remove_item_prompt, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                getContext());

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                mainList.removeGroceryList(position);
                                db.update(mainList);
                                mainList.add(position, gl);
                                db.update(mainList);
                                notifyDataSetChanged();
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

    private void renameList(final int position, final GroceryList gl) {
        LayoutInflater li = LayoutInflater.from(getContext());
        View promptsView = li.inflate(R.layout.rename_popup, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                getContext());

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);
        final EditText userInput = (EditText) promptsView.findViewById(R.id.newName);

        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String stringQuant = userInput.getText().toString();
                        Log.d("old name", gl.getName());
                        gl.renameList(stringQuant);
                        Log.d("new name", gl.getName());
                        mainList.removeGroceryList(position);
                        mainList.add(position, gl);
                        db.update(mainList);
                        notifyDataSetChanged();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alertDialog = alertDialogBuilder.create();

//        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
//                .setEnabled(false);


        userInput.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (mainList.contains(userInput.getText().toString())) {
                    Toast.makeText(getContext(), "This List Already Exists", Toast.LENGTH_SHORT).show();
                    ((AlertDialog) alertDialog).getButton(AlertDialog.BUTTON_POSITIVE)
                            .setEnabled(false);
                }
                else if(userInput.getText().length() == 0){
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
}

