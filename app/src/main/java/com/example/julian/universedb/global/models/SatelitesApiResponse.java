package com.example.julian.universedb.global.models;

import com.example.julian.universedb.db.entities.Satelites;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SatelitesApiResponse {

    @SerializedName("Satelites")
    @Expose
    public List<Satelites> satelites = null;
}
