package com.example.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {GroceryList.class},version = 1)
public abstract class MyAppDatabase extends RoomDatabase {
    public abstract  MyDao myDao();
}
