package com.bsuir.kloop1996.bookva.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bsuir.kloop1996.bookva.R;
import com.bsuir.kloop1996.bookva.model.entity.Work;
import com.bsuir.kloop1996.bookva.ui.view.activity.BookDetailActivity;
import com.bsuir.kloop1996.bookva.ui.view.fragment.AuthorizationFragment;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

/**
 * Created by kloop1996 on 12.05.2016.
 */
public class ItemWorkViewModel extends BaseObservable implements ViewModel {
    private Work work;
    private Context context;

    public ItemWorkViewModel(Context context, Work work) {
        this.context = context;
        this.work = work;
    }

    public String getTitle() {
        return work.getTitle();
    }

    public String getDescription() {
        return work.getDescription();
    }

    public String getRaiting() {
        return String.valueOf(work.getAverageRating()) + "\n Рейтинг";
    }

    public String getReviewsCount() {
        return String.valueOf(work.getReviewsCount()) + "\n Отзыва";
    }

    public String getPreviewCoverSource() {
        return work.getPreviewCoverSource();
    }

    public void setWork(Work work) {
        this.work = work;
        notifyChange();
    }


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
        Intent intent = new Intent(context, BookDetailActivity.class);
        intent.putExtra(BookDetailActivity.EXTRA_ID_WORK, work.getId());
        intent.putExtra(BookDetailActivity.EXTRA_TITLE, work.getTitle());

        context.startActivity(intent);
    }


}
