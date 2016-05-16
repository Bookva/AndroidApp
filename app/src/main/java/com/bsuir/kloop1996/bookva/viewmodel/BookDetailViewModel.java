package com.bsuir.kloop1996.bookva.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bsuir.kloop1996.bookva.BookvaAplication;
import com.bsuir.kloop1996.bookva.R;
import com.bsuir.kloop1996.bookva.core.BookvaService;
import com.bsuir.kloop1996.bookva.model.entity.Work;
import com.bsuir.kloop1996.bookva.model.entity.WorkInfo;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by kloop1996 on 16.05.2016.
 */
public class BookDetailViewModel implements ViewModel {

    public ObservableInt containerViewVisibility;
    public ObservableInt progressVisibility;

    public ObservableField<String> text;
    public ObservableField<String> description;
    public ObservableField<String> extract;
    public ObservableField<String> displayName;
    public ObservableField<String> imageUrl;

    private Context context;
    private Subscription subscription;
    private int idWork;
    private WorkInfo workInfo;


    public String getTitle() {
        //mock
        return null;
    }


    public BookDetailViewModel(Context context, int idWork) {
        this.context = context;
        this.idWork = idWork;

        progressVisibility = new ObservableInt(View.VISIBLE);
        containerViewVisibility = new ObservableInt(View.INVISIBLE);

        text = new ObservableField<String>();
        description = new ObservableField<String>();
        extract = new ObservableField<String>();
        imageUrl = new ObservableField<String>();
        displayName = new ObservableField<String>();


        loadDetailOfWork();

    }

    @Override
    public void destroy() {
        context = null;
    }

    @BindingAdapter({"bind:imageUri"})
    public static void loadImage(ImageView view, String imageUri) {
        Glide.with(view.getContext())
                .load(R.drawable.placeholder2)
                .fitCenter()
                .into(view);
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImageRemote(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }

    private void loadDetailOfWork() {
        final BookvaAplication bookvaAplication = BookvaAplication.get(context);
        BookvaService bookvaService = bookvaAplication.getBookvaService();

        if (subscription != null && !subscription.isUnsubscribed()) subscription.unsubscribe();

        subscription = bookvaService.getWorkInfo(idWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(bookvaAplication.defaultSubscribeScheduler())
                .subscribe(new Subscriber<WorkInfo>() {
                    @Override
                    public void onCompleted() {

                        containerViewVisibility.set(View.VISIBLE);
                        progressVisibility.set(View.INVISIBLE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(bookvaAplication, "Load error", Toast.LENGTH_LONG).show();
                        progressVisibility.set(View.INVISIBLE);
                    }

                    @Override
                    public void onNext(WorkInfo work) {
                        workInfo = work;
                        extract.set(work.extract);
                        text.set(work.text);
                        description.set(work.description);

                        imageUrl.set(workInfo.authors.get(0).getPreviewPicureSource());
                        displayName.set(work.authors.get(0).displayName);


                        Toast.makeText(bookvaAplication, "Load", Toast.LENGTH_LONG).show();

                    }
                });
    }
}
