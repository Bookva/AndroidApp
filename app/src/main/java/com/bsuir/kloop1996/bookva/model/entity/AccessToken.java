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

    public AccessToken(String token, String username, String tokenType) {
        this.token = token;
        this.tokenType = tokenType;
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccessToken that = (AccessToken) o;

        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null)
            return false;
        return tokenType != null ? tokenType.equals(that.tokenType) : that.tokenType == null;

    }

    @Override
    public int hashCode() {
        int result = token != null ? token.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (tokenType != null ? tokenType.hashCode() : 0);
        return result;
    }


}
