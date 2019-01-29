package com.example.julian.universedb.global.services;


import com.example.julian.universedb.db.entities.Result;
import com.example.julian.universedb.db.entities.User;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Santiago Battaglino.
 */
public interface RandomUserApiServic {

    @GET("/api/")
    Observable<Result<User>> getUsers(
            @Query("results") int results,
            @Query("page") int page
    );
}
