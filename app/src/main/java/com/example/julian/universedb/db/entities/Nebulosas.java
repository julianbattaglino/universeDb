package com.example.julian.universedb.db.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import io.reactivex.annotations.NonNull;


@Parcel
@Entity(tableName = "nebulosas", indices = @Index(value = {"uid"}))
public class Nebulosas {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @SerializedName("uid")
    @Expose
    public int uid;

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("tipo")
    @Expose
    public String tipo;
    @SerializedName("distancia")
    @Expose
    public String distancia;
    @SerializedName("diametro")
    @Expose
    public String diametro;
    @SerializedName("descripcion")
    @Expose
    public String descripcion;
    @SerializedName("constelacion")
    @Expose
    public String constelacion;
    @SerializedName("ascensi\u00f3nrecta")
    @Expose
    public String ascensiNrecta;
    @SerializedName("declinaci\u00f3n")
    @Expose
    public String declinaciN;
    @SerializedName("otras designaciones")
    @Expose
    public String otrasDesignaciones;
    @SerializedName("image")
    @Expose
    public String image;

    @Override
    public String toString() {
        return "Nebulosas{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tipo='" + tipo + '\'' +
                ", distancia='" + distancia + '\'' +
                ", diametro='" + diametro + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", constelacion='" + constelacion + '\'' +
                ", ascensiNrecta='" + ascensiNrecta + '\'' +
                ", declinaciN='" + declinaciN + '\'' +
                ", otrasDesignaciones='" + otrasDesignaciones + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

}
