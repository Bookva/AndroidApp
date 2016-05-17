package com.bsuir.kloop1996.bookva.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kloop1996 on 16.05.2016.
 */
public class WorkInfo {
    private String text;

    @SerializedName("extract1")
    private String extract;
    private String description;
    private List<AuthorPreview> authors;

    public WorkInfo(String text,String extract, String description,List<AuthorPreview> authorPreviews){
        this.text=text;
        this.extract = extract;
        this.description = description;
        this.authors= authorPreviews;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getExtract() {
        return extract;
    }

    public void setExtract(String extract) {
        this.extract = extract;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AuthorPreview> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorPreview> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkInfo workInfo = (WorkInfo) o;

        if (text != null ? !text.equals(workInfo.text) : workInfo.text != null) return false;
        if (extract != null ? !extract.equals(workInfo.extract) : workInfo.extract != null)
            return false;
        if (description != null ? !description.equals(workInfo.description) : workInfo.description != null)
            return false;
        return authors != null ? authors.equals(workInfo.authors) : workInfo.authors == null;

    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (extract != null ? extract.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        return result;
    }
}
