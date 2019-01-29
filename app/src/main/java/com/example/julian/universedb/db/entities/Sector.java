package com.example.julian.universedb.db.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sector {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("description")
    @Expose
    public String description;

    @Override
    public String toString() {
        return "Sector{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

