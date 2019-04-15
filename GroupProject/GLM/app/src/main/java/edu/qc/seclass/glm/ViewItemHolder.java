package edu.qc.seclass.glm;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class ViewItemHolder extends RecyclerView.ViewHolder {

    private CheckBox itemCheckbox;

    private TextView itemTextView;

    private  TextView quantity;

    public ViewItemHolder(View itemView) {
        super(itemView);
    }

    public CheckBox getItemCheckbox() {
        return itemCheckbox;
    }

    public void setItemCheckbox(CheckBox itemCheckbox) {
        this.itemCheckbox = itemCheckbox;
    }

    public TextView getItemTextView() {
        return itemTextView;
    }

    public TextView getItemQuantity() { return quantity;}
    public void setItemQuantity(TextView quantity) {
        this.quantity = quantity;
    }

    public void setItemTextView(TextView itemTextView) {
        this.itemTextView = itemTextView;
    }

}

