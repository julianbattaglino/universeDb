package com.example.julian.universedb.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.julian.universedb.db.entities.Satelites;

import java.util.List;

@Dao
public interface SatelitesDao {

    @Query("select * from satelites")
    LiveData<List<Satelites>> loadList();

    @Insert
    void insertList(List<Satelites> planetas);
}
