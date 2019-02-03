package com.example.julian.universedb.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.julian.universedb.db.entities.Planetarias;

import java.util.List;

@Dao
public interface PlanetariasDao {

    @Query("select * from NebulosasPlanetarias")
    LiveData<List<Planetarias>> loadList();

    @Insert
    void insertList(List<Planetarias> planetarias);
}