package com.bsuir.kloop1996.bookva.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableInt;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bsuir.kloop1996.bookva.BookvaAplication;
import com.bsuir.kloop1996.bookva.core.BookvaService;
import com.bsuir.kloop1996.bookva.model.entity.AuthorPreview;
import com.bsuir.kloop1996.bookva.model.entity.Work;
import com.bsuir.kloop1996.bookva.model.entity.WorkInfo;
import com.bsuir.kloop1996.bookva.ui.view.activity.BookDetailActivity;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by kloop1996 on 18.05.2016.
 */
public class AuthorPreviewViewModel implements ViewModel {
    public ObservableInt progressVisibility;
    public ObservableInt recyclerViewVisibility;


    private Context context;
    private Subscription subscription;
    private DataListener dataListener;
    private List<AuthorPreview> authorPreviews;


    public AuthorPreviewViewModel(Context context, DataListener dataListener){
        this.context= context;
        this.dataListener = dataListener;

        progressVisibility = new ObservableInt();
        recyclerViewVisibility = new ObservableInt();

        recyclerViewVisibility.set(View.INVISIBLE);
        progressVisibility.set(View.VISIBLE);

        loadAuthorPreviews();
    }

    @Override
    public void destroy() {
        context = null;
        subscription = null;
    }

    public interface DataListener {
        void onAuthorPreviewsChanged(List<AuthorPreview> authorPreviews);
    }

    private void loadAuthorPreviews(){
        final BookvaAplication bookvaAplication = BookvaAplication.get(context);
        BookvaService bookvaService = bookvaAplication.getBookvaService();

        if (subscription != null && !subscription.isUnsubscribed()) subscription.unsubscribe();

        subscription = bookvaService.getAuthorsPreviews()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(bookvaAplication.defaultSubscribeScheduler())
                .subscribe(new Subscriber<List<AuthorPreview>>() {
                    @Override
                    public void onCompleted() {
                        if (dataListener!=null)
                            dataListener.onAuthorPreviewsChanged(authorPreviews);

                        recyclerViewVisibility.set(View.VISIBLE);
                        progressVisibility.set(View.INVISIBLE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(bookvaAplication, "Load error", Toast.LENGTH_LONG).show();
                        progressVisibility.set(View.INVISIBLE);
                    }

                    @Override
                    public void onNext(List<AuthorPreview> authorPreviews) {

                        AuthorPreviewViewModel.this.authorPreviews = authorPreviews;
                        Toast.makeText(bookvaAplication, "Load", Toast.LENGTH_LONG).show();

                    }
                });
    }



}
