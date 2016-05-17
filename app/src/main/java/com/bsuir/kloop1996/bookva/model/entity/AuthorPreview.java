package com.bsuir.kloop1996.bookva.model.entity;

/**
 * Created by kloop1996 on 12.05.2016.
 */
public class AuthorPreview {
    private int id;
    private String displayName;
    private String pictureSource;
    private String previewPictureSource;

    public AuthorPreview(int id,String displayName,String pictureSource,String previewPictureSource){
        this.id=id;
        this.displayName=displayName;
        this.pictureSource=pictureSource;
        this.previewPictureSource=previewPictureSource;
    }

    public String getPreviewPictureSource() {
        return previewPictureSource;
    }

    public void setPreviewPictureSource(String previewPictureSource) {
        this.previewPictureSource = previewPictureSource;
    }

    public String getPictureSource() {
        return pictureSource;
    }

    public void setPictureSource(String pictureSource) {
        this.pictureSource = pictureSource;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorPreview that = (AuthorPreview) o;

        if (id != that.id) return false;
        if (displayName != null ? !displayName.equals(that.displayName) : that.displayName != null)
            return false;
        if (pictureSource != null ? !pictureSource.equals(that.pictureSource) : that.pictureSource != null)
            return false;
        return previewPictureSource != null ? previewPictureSource.equals(that.previewPictureSource) : that.previewPictureSource == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (pictureSource != null ? pictureSource.hashCode() : 0);
        result = 31 * result + (previewPictureSource != null ? previewPictureSource.hashCode() : 0);
        return result;
    }



}
