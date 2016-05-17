package com.bsuir.kloop1996.bookva.model.entity;

import java.util.Date;

/**
 * Created by kloop1996 on 17.05.2016.
 */
public class Review {
    private int id;
    private String title;
    private String text;
    private Date dateAdded;
    private UserPreview user;


    public Review(int id, String title, String text, Date dateAdded, UserPreview user) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.dateAdded = dateAdded;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public UserPreview getUser() {
        return user;
    }

    public void setUser(UserPreview user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (id != review.id) return false;
        if (title != null ? !title.equals(review.title) : review.title != null) return false;
        if (text != null ? !text.equals(review.text) : review.text != null) return false;
        if (dateAdded != null ? !dateAdded.equals(review.dateAdded) : review.dateAdded != null)
            return false;
        return user != null ? user.equals(review.user) : review.user == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (dateAdded != null ? dateAdded.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
