package com.example.julian.universedb.db.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import io.reactivex.annotations.NonNull;


@Parcel
@Entity(tableName = "Planetas", indices = @Index(value = {"uid"}))
public class Planetas {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @SerializedName("uid")
    @Expose
    public int uid;

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("categoria")
    @Expose
    public String categoria;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("magnitud aparente")
    @Expose
    public String magnitudAparente;
    @SerializedName("elementos orbitales")
    @Expose
    public String elementosOrbitales;
    @SerializedName("elementos orbitales derivados")
    @Expose
    public String elementosOrbitalesDerivados;
    @SerializedName("atmosfera")
    @Expose
    public String atmosfera;
    @SerializedName("caracteristicas principales")
    @Expose
    public String caracteristicasPrincipales;
    @SerializedName("caracteristicas f\u00edsicas")
    @Expose
    public String caracteristicasFSicas;
    @SerializedName("caracteristicas atmosf\u00e9ricas")
    @Expose
    public String caracteristicasAtmosfRicas;
    @SerializedName("masa")
    @Expose
    public String masa;
    @SerializedName("satelites")
    @Expose
    public String satelites;
    @SerializedName("otros datos")
    @Expose
    public String otrosDatos;
    @SerializedName("image")
    @Expose
    public String image;

    @Override
    public String toString() {
        return "Planetas{" +
                "uid=" + uid +
                ", id='" + id + '\'' +
                ", categoria='" + categoria + '\'' +
                ", name='" + name + '\'' +
                ", magnitudAparente='" + magnitudAparente + '\'' +
                ", elementosOrbitales='" + elementosOrbitales + '\'' +
                ", elementosOrbitalesDerivados='" + elementosOrbitalesDerivados + '\'' +
                ", atmosfera='" + atmosfera + '\'' +
                ", caracteristicasPrincipales='" + caracteristicasPrincipales + '\'' +
                ", caracteristicasFSicas='" + caracteristicasFSicas + '\'' +
                ", caracteristicasAtmosfRicas='" + caracteristicasAtmosfRicas + '\'' +
                ", masa='" + masa + '\'' +
                ", satelites='" + satelites + '\'' +
                ", otrosDatos='" + otrosDatos + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}

