package com.bsuir.kloop1996.bookva.viewmodel;

import android.content.Context;
import android.databinding.ObservableInt;
import android.view.View;
import android.widget.Toast;

import com.bsuir.kloop1996.bookva.BookvaAplication;
import com.bsuir.kloop1996.bookva.core.BookvaService;
import com.bsuir.kloop1996.bookva.model.entity.Work;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by kloop1996 on 12.05.2016.
 */
public class WorkListViewModel {


    private Context context;
    private DataListener dataListener;
    private Subscription subscription;
    private List<Work> works;

    public ObservableInt recyclerViewVisibility;
    public ObservableInt progressVisibility;

    public WorkListViewModel(Context context, DataListener dataListener) {
        this.context=context;
        this.dataListener=dataListener;
        recyclerViewVisibility = new ObservableInt(View.INVISIBLE);
        progressVisibility = new ObservableInt(View.VISIBLE);
        loadListWork();
    }

    private void loadListWork() {
        final BookvaAplication bookvaAplication = BookvaAplication.get(context);
        BookvaService bookvaService = bookvaAplication.getBookvaService();

        if (subscription != null && !subscription.isUnsubscribed()) subscription.unsubscribe();

        subscription = bookvaService.getAllWorks()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(bookvaAplication.defaultSubscribeScheduler())
                .subscribe(new Subscriber<List<Work>>() {
                    @Override
                    public void onCompleted() {
                        if (dataListener!=null)
                            dataListener.onRepositoriesChanged(works);
                        recyclerViewVisibility.set(View.VISIBLE);
                        progressVisibility.set(View.INVISIBLE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(bookvaAplication, "Load error", Toast.LENGTH_LONG).show();
                        progressVisibility.set(View.INVISIBLE);
                    }

                    @Override
                    public void onNext(List<Work> works) {
                        WorkListViewModel.this.works = works;
                        Toast.makeText(bookvaAplication, "Load", Toast.LENGTH_LONG).show();

                    }
                });
    }

    public interface DataListener {
        void onRepositoriesChanged(List<Work> work);
    }
}
