package com.example.julian.universedb.global.services;

import com.example.julian.universedb.global.models.NebulasApiResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NebulasApiServices {

    @GET("/julianbattaglino/dbjson/Nebulosas")
    Observable<NebulasApiResponse> getNebulas(
    );
}


