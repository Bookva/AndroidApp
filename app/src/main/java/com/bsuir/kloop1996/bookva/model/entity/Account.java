package com.bsuir.kloop1996.bookva.model.entity;

import java.util.Date;

/**
 * Created by kloop1996 on 17.05.2016.
 */
public class Account {
    private int id;
    private String username;
    private String email;
    private Date registrationDate;
    private String pictureSource;
    private int authorid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getPictureSource() {
        return pictureSource;
    }

    public void setPictureSource(String pictureSource) {
        this.pictureSource = pictureSource;
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public Account(int id, String username, String email, Date registrationDate, String pictureSource, int authorid) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.registrationDate = registrationDate;
        this.pictureSource = pictureSource;
        this.authorid = authorid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (authorid != account.authorid) return false;
        if (username != null ? !username.equals(account.username) : account.username != null)
            return false;
        if (email != null ? !email.equals(account.email) : account.email != null) return false;
        if (registrationDate != null ? !registrationDate.equals(account.registrationDate) : account.registrationDate != null)
            return false;
        return pictureSource != null ? pictureSource.equals(account.pictureSource) : account.pictureSource == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (pictureSource != null ? pictureSource.hashCode() : 0);
        result = 31 * result + authorid;
        return result;
    }
}
