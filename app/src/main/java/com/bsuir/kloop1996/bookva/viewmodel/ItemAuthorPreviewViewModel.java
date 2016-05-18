package com.bsuir.kloop1996.bookva.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bsuir.kloop1996.bookva.R;
import com.bsuir.kloop1996.bookva.model.entity.AuthorPreview;
import com.bsuir.kloop1996.bookva.model.entity.Work;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

/**
 * Created by kloop1996 on 18.05.2016.
 */
public class ItemAuthorPreviewViewModel extends BaseObservable implements ViewModel {
    private Context context;
    private AuthorPreview authorPreview;

    public ItemAuthorPreviewViewModel(Context context, AuthorPreview authorPreview){
        this.context=context;
        this.authorPreview=authorPreview;
    }

    public String getDisplayName(){return authorPreview.getDisplayName();}
    public String getPreviewPictureSource(){return authorPreview.getPreviewPictureSource();}

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        if (imageUrl != null && imageUrl.length()!=0) {
            Picasso.with(view.getContext())
                    .load(imageUrl).placeholder(R.drawable.user_placeholder)
                    .into(view);
        } else
            Glide.with(view.getContext())
                    .load(R.drawable.user_placeholder)
                    .into(view);
    }

    @Override
    public void destroy() {
        context = null;
    }

    public void onClick(View v) {
        Context context = v.getContext();

    }
}
