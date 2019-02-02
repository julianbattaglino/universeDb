package com.example.julian.universedb.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.julian.universedb.db.entities.Nebulosas;

import java.util.List;

@Dao
public interface NebulosasDao {

    @Query("select * from nebulosas")
    LiveData<List<Nebulosas>> loadList();

    @Insert
    void insertList(List<Nebulosas> nebulosas);
}

