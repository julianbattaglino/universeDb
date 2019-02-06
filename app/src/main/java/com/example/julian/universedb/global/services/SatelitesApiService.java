package com.example.julian.universedb.global.services;

import com.example.julian.universedb.global.models.SatelitesApiResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface SatelitesApiService {

    @GET("/juli/satelitesnaturales/satelitesnaturales.json")
    Observable<SatelitesApiResponse> getSatelites(
    );
}

