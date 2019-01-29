package com.example.julian.universedb.db.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import io.reactivex.annotations.NonNull;

@Parcel
@Entity(tableName = "myusers", indices = @Index(value = {"uid"}))

public class Users {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @SerializedName("uid")
    @Expose
    public int uid;

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("firstName")
    @Expose
    public String firstName;
    @SerializedName("lastName")
    @Expose
    public String lastName;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("telephone")
    @Expose
    public String telephone;
    @SerializedName("nationality")
    @Expose
    public String nationality;
    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("State")
    @Expose
    public String state;
    @SerializedName("age")
    @Expose
    public String age;
    @SerializedName("picture_url")
    @Expose
    public String pictureUrl;
    @SerializedName("sectorId")
    @Expose
    public String sectorId;

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", nationality='" + nationality + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", age='" + age + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", sectorId='" + sectorId + '\'' +
                '}';
    }
}

