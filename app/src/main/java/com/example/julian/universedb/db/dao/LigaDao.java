package com.example.julian.universedb.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.julian.universedb.db.entities.Liga;

import java.util.List;

/**
 * Created by Santiago Battaglino.
 */
@Dao
public interface LigaDao {

    @Query("select * from ligas")
    LiveData<List<Liga>> loadList();

    @Insert
    void insertList(List<Liga> ligas);
}
