package com.example.julian.universedb.global.models;


import com.example.julian.universedb.db.entities.Sector;
import com.example.julian.universedb.db.entities.Users;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ApiResponse {


    @SerializedName("Users")
    @Expose
    public List<Users> users = null;
    @SerializedName("sectors")
    @Expose
    public List<Sector> sectors = null;
}



