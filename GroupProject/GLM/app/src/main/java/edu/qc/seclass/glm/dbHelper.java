package edu.qc.seclass.glm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Blob;

public class dbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="GroceryDB";
    private static final String TABLE_NAME ="ListsofLists";
    private static final String GL_ID="GL_ID";
//    private static final String GL_NAME="GL_NAME";
    private static final String GL_DATA="DATA_ID";



    private final Context context;


    public dbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE "+TABLE_NAME + " ("+GL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+GL_DATA+" BLOB);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
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

    public long insertData(String name, ListOfLists gl){
      byte[] data = makeByte(gl);
       SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cvs = new ContentValues();
      cvs.put(dbHelper.TABLE_NAME,  name);
        cvs.put(dbHelper.GL_DATA, data);
        long id = db.insert(dbHelper.TABLE_NAME, null, cvs);
        return id;
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


}
