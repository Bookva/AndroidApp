package com.example.kloop1996.bookva.model.entity;

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

    public Author(String name,String surname,Date dateOfBirth,int id, String pictureSource, String previewPictureSource,String pseudonym,boolean usePseudonym){
        this.name=name;
        this.surname=surname;
        this.dateOfBirth=dateOfBirth;
        this.id=id;
        this.pictureSource=pictureSource;
        this.previewPictureSource=previewPictureSource;
        this.pseudonym=pseudonym;
        this.usePseudonym=usePseudonym;
    }
}
