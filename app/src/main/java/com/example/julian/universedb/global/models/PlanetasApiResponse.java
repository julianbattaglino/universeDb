package com.example.julian.universedb.global.models;

import com.example.julian.universedb.db.entities.Planetas;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlanetasApiResponse {

    @SerializedName("Planetas")
    @Expose
    public List<Planetas> planetas = null;

}

