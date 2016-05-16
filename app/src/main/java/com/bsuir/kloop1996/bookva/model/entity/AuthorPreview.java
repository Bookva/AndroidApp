package com.bsuir.kloop1996.bookva.model.entity;

/**
 * Created by kloop1996 on 12.05.2016.
 */
public class AuthorPreview {
    public int id;
    public String displayName;
    public String pictureSource;
    public String previewPicureSource;

    public AuthorPreview(int id,String displayName,String pictureSource,String previewPicureSource){
        this.id=id;
        this.displayName=displayName;
        this.pictureSource=pictureSource;
        this.previewPicureSource=previewPicureSource;
    }


    public String getDisplayName(){return displayName;}
    public String getPreviewPicureSource(){return previewPicureSource;}
}
