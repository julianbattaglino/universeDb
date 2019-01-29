package com.example.julian.universedb.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.julian.universedb.db.entities.Users;

import java.util.List;

@Dao
public interface UsersDao {

    @Query("select * from myusers")
    LiveData<List<Users>> loadList();

    @Insert
    void insertList(List<Users> users);
}

