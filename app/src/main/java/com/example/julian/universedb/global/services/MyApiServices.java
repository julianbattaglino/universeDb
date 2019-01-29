package com.example.julian.universedb.global.services;


import com.example.julian.universedb.global.models.ApiResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyApiServices {

    @GET("/julianbattaglino/dbjson/db")
    Observable<ApiResponse> getApiResponse(
    );
}
