package com.bsuir.kloop1996.bookva.model.entity;

import java.util.List;

/**
 * Created by kloop1996 on 19.04.2016.
 */
public class Work {
    private int id;
    private String title;
    private String description;
    private String status;
    private boolean isAnonymous;
    private String coverSource;
    private String previewCoverSource;
    private int averageRating;
    private int reviewsCount;
    private List<AuthorPreview> authors;

    public Work(int id, String title, String description, String status
            , boolean isAnonymous, String coverSource, String previewCoverSource, int averageRaitng, int reviewsCount, List<AuthorPreview> authors) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.description = description;
        this.status = status;
        this.isAnonymous = isAnonymous;
        this.coverSource = coverSource;
        this.previewCoverSource = previewCoverSource;
        this.averageRating = averageRaitng;
        this.reviewsCount = reviewsCount;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

    public String getCoverSource() {
        return coverSource;
    }

    public void setCoverSource(String coverSource) {
        this.coverSource = coverSource;
    }

    public String getPreviewCoverSource() {
        return previewCoverSource;
    }

    public void setPreviewCoverSource(String previewCoverSource) {
        this.previewCoverSource = previewCoverSource;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }

    public int getReviewsCount() {
        return reviewsCount;
    }

    public void setReviewsCount(int reviewsCount) {
        this.reviewsCount = reviewsCount;
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

        Work work = (Work) o;

        if (id != work.id) return false;
        if (isAnonymous != work.isAnonymous) return false;
        if (averageRating != work.averageRating) return false;
        if (reviewsCount != work.reviewsCount) return false;
        if (title != null ? !title.equals(work.title) : work.title != null) return false;
        if (description != null ? !description.equals(work.description) : work.description != null)
            return false;
        if (status != null ? !status.equals(work.status) : work.status != null) return false;
        if (coverSource != null ? !coverSource.equals(work.coverSource) : work.coverSource != null)
            return false;
        if (previewCoverSource != null ? !previewCoverSource.equals(work.previewCoverSource) : work.previewCoverSource != null)
            return false;
        return authors != null ? authors.equals(work.authors) : work.authors == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (isAnonymous ? 1 : 0);
        result = 31 * result + (coverSource != null ? coverSource.hashCode() : 0);
        result = 31 * result + (previewCoverSource != null ? previewCoverSource.hashCode() : 0);
        result = 31 * result + averageRating;
        result = 31 * result + reviewsCount;
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        return result;
    }
}
