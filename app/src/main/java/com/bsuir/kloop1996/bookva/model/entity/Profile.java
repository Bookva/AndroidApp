package com.bsuir.kloop1996.bookva.model.entity;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profile profile = (Profile) o;

        if (name != null ? !name.equals(profile.name) : profile.name != null) return false;
        if (email != null ? !email.equals(profile.email) : profile.email != null) return false;
        return password != null ? password.equals(profile.password) : profile.password == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
