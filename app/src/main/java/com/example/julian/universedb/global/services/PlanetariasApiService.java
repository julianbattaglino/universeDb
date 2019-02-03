package com.example.julian.universedb.global.services;

import com.example.julian.universedb.global.models.PlanetariasApiResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PlanetariasApiService {

    @GET("/juli/nebulosas/nebulosasplanetarias.json")
    Observable<PlanetariasApiResponse> getPlanetarias(
    );
}

