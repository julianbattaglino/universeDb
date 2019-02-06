package com.example.julian.universedb.global.services;

import com.example.julian.universedb.global.models.PlanetasApiResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PlanetasApiService {

    @GET("/juli/planetas/planetas.json")
    Observable<PlanetasApiResponse> getPlanetas(
    );
}