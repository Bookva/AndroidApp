package com.example.kloop1996.bookva.model.entity;

import java.util.List;

/**
 * Created by kloop1996 on 19.04.2016.
 */
public class Work {
    public int id;
    public String title;
    public String description;
    public String status;
    public boolean isAnonymous;
    public String coverSource;
    public String previewCoverSource;
    public int averageRating;
    public int reviewsCount;
    public List<AuthorPreview> authors;

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
}
