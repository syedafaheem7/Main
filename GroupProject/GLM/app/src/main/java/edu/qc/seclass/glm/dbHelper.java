package edu.qc.seclass.glm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;

public class dbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="GroceryDB";
    private static final String TABLE_NAME ="ListsofLists";
    private static final String GL_ID="GL_ID";
    private static final String GL_DATA="DATA";
    private static final String ITEM_TYPE_TABLE_NAME ="ItemType";
    private static final String IT_ID="ITEM_TYPE_ID";
    private static final String IT_NAME="ITEM_TYPE_NAME";



    private final Context context;


    public dbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE "+TABLE_NAME + " ("+GL_ID+" INTEGER PRIMARY KEY, "+GL_DATA+" BLOB);";
        db.execSQL(createTable);
        createTable = "CREATE TABLE "+ITEM_TYPE_TABLE_NAME + " ("+IT_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+IT_NAME+" VARCHAR(250));";
        db.execSQL(createTable);
        ContentValues cv = new ContentValues();
        cv.put(dbHelper.IT_NAME, "Beverages");
        db.insert(ITEM_TYPE_TABLE_NAME, null, cv);
        cv.put(dbHelper.IT_NAME, "Bread/Bakery");
        db.insert(ITEM_TYPE_TABLE_NAME, null, cv);
        cv.put(dbHelper.IT_NAME, "Canned/Jarred Goods");
        db.insert(ITEM_TYPE_TABLE_NAME, null, cv);
        cv.put(dbHelper.IT_NAME, "Dairy");
        db.insert(ITEM_TYPE_TABLE_NAME, null, cv);
        cv.put(dbHelper.IT_NAME, "Dry/Baking Goods");
        db.insert(ITEM_TYPE_TABLE_NAME, null, cv);
        cv.put(dbHelper.IT_NAME, "Frozen Foods");
        db.insert(ITEM_TYPE_TABLE_NAME, null, cv);
        cv.put(dbHelper.IT_NAME, "Meat");
        db.insert(ITEM_TYPE_TABLE_NAME, null, cv);
        cv.put(dbHelper.IT_NAME, "Produce");
        db.insert(ITEM_TYPE_TABLE_NAME, null, cv);
        cv.put(dbHelper.IT_NAME, "Cleaners");
        db.insert(ITEM_TYPE_TABLE_NAME, null, cv);
        cv.put(dbHelper.IT_NAME, "Paper Goods ");
        db.insert(ITEM_TYPE_TABLE_NAME, null, cv);
        cv.put(dbHelper.IT_NAME, "Personal Care");
        db.insert(ITEM_TYPE_TABLE_NAME, null, cv);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ITEM_TYPE_TABLE_NAME);
        onCreate(db);
    }

    public void update(ListOfLists l){
        byte[] lolB = makeByte(l);
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(dbHelper.GL_DATA, lolB);
        db.update(TABLE_NAME, cv, GL_ID + "=2", null);
    }

    public byte[] makeByte(ListOfLists gl){
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(gl);
            byte[] glByte = baos.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(glByte);

            return glByte;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ListOfLists getByte(byte[] glByte) {
        if (glByte != null) {

            try {
                ByteArrayInputStream bais = new ByteArrayInputStream(glByte);
                ObjectInputStream ois = new ObjectInputStream(bais);
                ListOfLists gl = (ListOfLists) ois.readObject();
                return gl;
            } catch(IOException e){
                e.printStackTrace();
            } catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public void insertData(ListOfLists gl){
      byte[] data = makeByte(gl);
       SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cvs = new ContentValues();
        //cvs.put(dbHelper.TABLE_NAME,  name);
        cvs.put(dbHelper.GL_ID, 2);
        cvs.put(dbHelper.GL_DATA, data);
        db.insert(dbHelper.TABLE_NAME, null, cvs);
    }

    public ListOfLists getData(){
        ListOfLists lol = null;
        String[] glData = {dbHelper.GL_DATA};
        SQLiteDatabase db = getWritableDatabase();
        Cursor data  = db.query(true, dbHelper.TABLE_NAME, glData, null, null, null, null, null, null, null);
        while(data.moveToNext()){
            byte[] lolBytes = data.getBlob(data.getColumnIndex(dbHelper.GL_DATA));
            lol = getByte(lolBytes);
        }
        return lol;
    }

    public ArrayList<String> getItems(){
        ArrayList<String> items = new ArrayList<String>();
        String[] glData = {dbHelper.IT_NAME};
        SQLiteDatabase db = getWritableDatabase();
        Cursor data  = db.query(true, dbHelper.ITEM_TYPE_TABLE_NAME, glData, null, null, null, null, null, null, null);
        while(data.moveToNext()){
            items.add(data.getString(data.getColumnIndex(dbHelper.IT_NAME)));
        }
        return items;
    }

    public void insertItem(String i){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(dbHelper.IT_NAME, i);
        db.insert(ITEM_TYPE_TABLE_NAME, null, cv);
    }

}
