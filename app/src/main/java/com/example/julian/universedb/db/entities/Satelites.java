package com.example.julian.universedb.db.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import io.reactivex.annotations.NonNull;


@Parcel
@Entity(tableName = "Satelites", indices = @Index(value = {"uid"}))
public class Satelites {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @SerializedName("uid")
    @Expose
    public int uid;

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("tipo")
    @Expose
    public String tipo;
    @SerializedName("planeta")
    @Expose
    public String planeta;
    @SerializedName("nombre")
    @Expose
    public String nombre;
    @SerializedName("caracteristicas")
    @Expose
    public String caracteristicas;
    @SerializedName("descubridor")
    @Expose
    public String descubridor;
    @SerializedName("image")
    @Expose
    public String image;

    @Override
    public String toString() {
        return "Satelites{" +
                "uid=" + uid +
                ", id='" + id + '\'' +
                ", tipo='" + tipo + '\'' +
                ", planeta='" + planeta + '\'' +
                ", nombre='" + nombre + '\'' +
                ", caracteristicas='" + caracteristicas + '\'' +
                ", descubridor='" + descubridor + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}

