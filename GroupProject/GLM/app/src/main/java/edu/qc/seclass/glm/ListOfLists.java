package edu.qc.seclass.glm;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ListOfLists extends ArrayList<GroceryList> implements Parcelable {

    public ListOfLists(){
        super();
    }

    protected ListOfLists(Parcel in) {
    }

    public static final Creator<ListOfLists> CREATOR = new Creator<ListOfLists>() {
        @Override
        public ListOfLists createFromParcel(Parcel in) {
            return new ListOfLists(in);
        }

        @Override
        public ListOfLists[] newArray(int size) {
            return new ListOfLists[size];
        }
    };

    public void addList(String n){
        GroceryList gl = new GroceryList(n);
        this.add(gl);
    }

    public void removeList(ArrayList<GroceryList> gl){
        this.remove(gl);

    }

    public static void selectList(ArrayList<GroceryList> gl){

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

//
//    public static class ItemListAdapter {
//
//
////        public class GListViewAdapter extends ArrayAdapter<GroceryList> {
////
////            ArrayList<GroceryList> mainList = new ArrayList<>();
////
////            public GListViewAdapter(Context context, int textViewResourceId, ArrayList<GroceryList> mainList) {
////                super(context, textViewResourceId, mainList);
////                this.mainList = mainList;
////            }
////
////            @Override
////            public int getCount() {
////                return super.getCount();
////            }
////
////
////            @Override
////            public View getView(int position, View convertView, ViewGroup parent) {
////
////                View v = convertView;
////                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
////                v = inflater.inflate(R.layout.list_of_lists_items_view, null);
////                TextView textView = (TextView) v.findViewById(R.id.textView);
////                ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
////    //        CheckBox imageView = (CheckBox) v.findViewById(R.id.chk_box);
////                textView.setText(mainList.get(position).getName());
////                imageView.setImageResource(R.mipmap.gridimage);
////                return v;
////
////            }
////
////        }
////
////
////    }
}
