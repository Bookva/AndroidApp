package com.example.kloop1996.bookva.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.kloop1996.bookva.R;
import com.example.kloop1996.bookva.model.entity.Work;
import com.squareup.picasso.Picasso;

/**
 * Created by kloop1996 on 12.05.2016.
 */
public class ItemWorkViewModel extends BaseObservable implements ViewModel {
    private Work work;
    private Context context;

    public ItemWorkViewModel(Context context,Work work){
        this.context=context;
        this.work=work;
    }

    public String getTitle(){return work.title;}
    public String getDescription(){return work.description;}
    public String getRaiting(){return String.valueOf(work.averageRating) +"\n Рейтинг";}
    public String getReviewsCount(){return String.valueOf(work.reviewsCount)+"\n Отзыва";}
    public String getPreviewCoverSource(){return work.previewCoverSource;}

    public void setWork(Work work){
        this.work=work;
        notifyChange();
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }

    @Override
    public void destroy() {
        context = null;
    }
}
