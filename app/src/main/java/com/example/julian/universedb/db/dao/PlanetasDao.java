package com.example.julian.universedb.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.julian.universedb.db.entities.Planetas;

import java.util.List;

@Dao
public interface PlanetasDao {

    @Query("select * from planetas")
    LiveData<List<Planetas>> loadList();

    @Insert
    void insertList(List<Planetas> satelites);
}
