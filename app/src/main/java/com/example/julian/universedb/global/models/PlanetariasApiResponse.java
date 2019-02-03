package com.example.julian.universedb.global.models;

import com.example.julian.universedb.db.entities.Planetarias;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlanetariasApiResponse {

    @SerializedName("Planetarias")
    @Expose
    public List<Planetarias> planetarias = null;

}