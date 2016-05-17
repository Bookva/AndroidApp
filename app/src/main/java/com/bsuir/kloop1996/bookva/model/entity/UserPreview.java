package com.bsuir.kloop1996.bookva.model.entity;

/**
 * Created by kloop1996 on 17.05.2016.
 */
public class UserPreview {
    private int id;
    private String username;
    private String previewPictrueSource;

    public UserPreview(int id, String username, String previewPictrueSource) {
        this.id = id;
        this.username = username;
        this.previewPictrueSource = previewPictrueSource;
    }

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

    public String getPreviewPictrueSource() {
        return previewPictrueSource;
    }

    public void setPreviewPictrueSource(String previewPictrueSource) {
        this.previewPictrueSource = previewPictrueSource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPreview that = (UserPreview) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null)
            return false;
        return previewPictrueSource != null ? previewPictrueSource.equals(that.previewPictrueSource) : that.previewPictrueSource == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (previewPictrueSource != null ? previewPictrueSource.hashCode() : 0);
        return result;
    }
}
