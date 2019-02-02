package com.example.julian.universedb.global.models;

import com.example.julian.universedb.db.entities.Nebulosas;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NebulasApiResponse {

    @SerializedName("Nebulosas")
    @Expose
    public List<Nebulosas> Nebulosas = null;

}

