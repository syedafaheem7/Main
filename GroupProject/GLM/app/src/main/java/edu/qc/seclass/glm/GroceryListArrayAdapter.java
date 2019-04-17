package edu.qc.seclass.glm;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
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

public class GroceryListArrayAdapter extends ArrayAdapter<Item> {

    GroceryList items;
    dbHelper db= new dbHelper(getContext());
    ListOfLists lol = db.getData();


    public GroceryListArrayAdapter(Context context, GroceryList items) {
        super(context, R.layout.grocery_list_items_view, items);
        this.items = items;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }


    @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

        ViewItemHolder viewHolder = null;

        if(convertView!=null)
        {
            viewHolder = (ViewItemHolder) convertView.getTag();
        }
            convertView = View.inflate(getContext(), R.layout.grocery_list_items_view, null);

            CheckBox listItemCheckbox = (CheckBox) convertView.findViewById(R.id.chk_box);

            TextView quantity = (TextView) convertView.findViewById(R.id.quantity);

            final ImageView elipses = (ImageView) convertView.findViewById(R.id.more);


            TextView listItemText = (TextView) convertView.findViewById(R.id.textView);

            viewHolder = new ViewItemHolder(convertView);

            viewHolder.setItemCheckbox(listItemCheckbox);

            viewHolder.setItemQuantity(quantity);

            viewHolder.setItemTextView(listItemText);

            convertView.setTag(viewHolder);


        final Item item = items.get(position);
        viewHolder.getItemCheckbox().setChecked(item.isChecked());
        viewHolder.getItemTextView().setText(item.getName());
        viewHolder.getItemQuantity().setText(String.valueOf(item.getQuantity()));

        listItemCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setChecked(!item.isChecked);
            }
        });


        elipses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pm = new PopupMenu(getContext(), elipses);
                pm.getMenuInflater().inflate(R.menu.more, pm.getMenu());
                pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem itm) {
                       switch (itm.getItemId()){
                           case R.id.changeQuant:
                                changeQuantity(item, position);
                                break;
                           case R.id.removePopUp:
                               renameList(item, position);
                       }
                        return true;
                    }
                });
                pm.show();
            }
        });


        return convertView;
    }

    private void changeQuantity(final Item item, final int position) {
        LayoutInflater li = LayoutInflater.from(getContext());
        View promptsView = li.inflate(R.layout.change_quanitity_popup, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                getContext());

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView.findViewById(R.id.quantityInpuuttt);


        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            String stringQuant =   userInput.getText().toString();
                                item.setQuantity(Integer.parseInt(stringQuant));
                                lol.removeGroceryList(position);
                                lol.add(position, items);
                                db.update(lol);
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
        final  AlertDialog alertDialog = alertDialogBuilder.create();

        userInput.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if ( !isInteger(userInput.getText().toString()) ||Integer.parseInt(userInput.getText().toString())< 0 ) {
                    Toast.makeText(getContext(), "Quantity must be a positive integer", Toast.LENGTH_SHORT).show();
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

    private void renameList(final Item item, final int position) {
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
                        item.setName(stringQuant);
                        lol.removeGroceryList(position);
                        lol.add(position, items);
                        db.update(lol);
                        notifyDataSetChanged();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
         final  AlertDialog alertDialog = alertDialogBuilder.create();

        userInput.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (items.contains(userInput.getText().toString()) || userInput.getText().length() == 0) {
                    Toast.makeText(getContext(), "This Item Already Exists", Toast.LENGTH_SHORT).show();
                    ((AlertDialog) alertDialog).getButton(AlertDialog.BUTTON_POSITIVE)
                            .setEnabled(false);
                }
                else ((AlertDialog) alertDialog).getButton(AlertDialog.BUTTON_POSITIVE)
                        .setEnabled(true);
            }

            public void afterTextChanged(Editable s) {

            }
        });

        alertDialog.show();
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
    }
}
