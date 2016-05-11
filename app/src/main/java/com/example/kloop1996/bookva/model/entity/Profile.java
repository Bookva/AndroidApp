package com.example.kloop1996.bookva.model.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kloop1996 on 09.05.2016.
 */
public class Profile {
    @SerializedName("login")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    public Profile(String name,String password, String email) {
        this.email = email;
        this.name = name;
        this.password=password;

    }
}
