package com.bsuir.kloop1996.bookva.model.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kloop1996 on 09.05.2016.
 */
public class AccessToken {
    @SerializedName("access_token")
    private String token;

    @SerializedName("userName")
    private String username;

    @SerializedName("token_type")
    private String tokenType;

    public String getToken(){return token;}
    public String getUsername(){return username;}
    public String getTokenType(){return tokenType;}

    public AccessToken(String token, String username, String tokenType) {
        this.token = token;
        this.tokenType = tokenType;
        this.username = username;
    }
}