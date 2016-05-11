package com.example.kloop1996.bookva.model.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kloop1996 on 20.04.2016.
 */
public class Genre {
    @SerializedName("value")
    private String name;

    @SerializedName("id")
    private int id;

    public Genre(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
