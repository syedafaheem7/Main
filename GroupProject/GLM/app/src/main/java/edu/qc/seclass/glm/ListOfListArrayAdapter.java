package edu.qc.seclass.glm;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;

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

                            case R.id.remove:
                                mainList.removeGroceryList(position);
                                db.update(mainList);
                                notifyDataSetChanged();
                        }
                        return true;
                    }
                });
                pm.show();
            }
        });

        return v;

    }

    private void renameList(final int position, final GroceryList gl) {
        LayoutInflater li = LayoutInflater.from(getContext());
        View promptsView = li.inflate(R.layout.rename, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                getContext());

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);
        final EditText userInput = (EditText) promptsView.findViewById(R.id.quantityInpuuttt);

        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String stringQuant = userInput.getText().toString();
                        gl.renameList(stringQuant);
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
        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }
}

