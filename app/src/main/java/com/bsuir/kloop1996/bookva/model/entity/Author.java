package com.bsuir.kloop1996.bookva.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by kloop1996 on 19.04.2016.
 */
public class Author {
    @SerializedName("name")
    private String name;

    @SerializedName("surname")
    private String surname;

    @SerializedName("dateOfBirth")
    private Date dateOfBirth;

    @SerializedName("id")
    private int id;

    @SerializedName("pictureSource")
    private String pictureSource;

    @SerializedName("previewPictureSource")
    private String previewPictureSource;

    @SerializedName("pseudonym")
    private String pseudonym;

    @SerializedName("usePseudonym")
    private boolean usePseudonym;

    public Author(String name, String surname, Date dateOfBirth, int id, String pictureSource, String previewPictureSource, String pseudonym, boolean usePseudonym){
        this.name=name;
        this.surname=surname;
        this.dateOfBirth=dateOfBirth;
        this.id=id;
        this.pictureSource=pictureSource;
        this.previewPictureSource=previewPictureSource;
        this.pseudonym=pseudonym;
        this.usePseudonym=usePseudonym;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPictureSource() {
        return pictureSource;
    }

    public void setPictureSource(String pictureSource) {
        this.pictureSource = pictureSource;
    }

    public String getPreviewPictureSource() {
        return previewPictureSource;
    }

    public void setPreviewPictureSource(String previewPictureSource) {
        this.previewPictureSource = previewPictureSource;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public boolean isUsePseudonym() {
        return usePseudonym;
    }

    public void setUsePseudonym(boolean usePseudonym) {
        this.usePseudonym = usePseudonym;
    }
}
