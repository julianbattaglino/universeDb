package com.example.julian.universedb.global.services;


import com.example.julian.universedb.db.entities.Liga;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Santiago Battaglino.
 */
public interface LOLApiService {

    @GET("/lol/league/v4/positions/by-summoner/{summoner}/")
    Observable<List<Liga>> getLigas(
            @Path("summoner") String summoner,
            @Query("api_key") String apiKey
    );
}
