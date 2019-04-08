package com.example.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;
import java.util.Queue;

@Dao
public interface MyDao {
    @Insert
    public void createList(GroceryList groceryList);

    @Delete
    public void removeList(GroceryList groceryList);

    @Query("select * from GroceryList")
    public List<GroceryList> getUsers();
}
