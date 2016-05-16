package com.bsuir.kloop1996.bookva.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kloop1996 on 16.05.2016.
 */
public class WorkInfo {
    public String text;

    @SerializedName("extract1")
    public String extract;
    public String description;
    public List<AuthorPreview> authors;

    public WorkInfo(String text,String extract, String description,List<AuthorPreview> authorPreviews){
        this.text=text;
        this.extract = extract;
        this.description = description;
        this.authors= authorPreviews;
    }
}
