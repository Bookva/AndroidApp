package com.example.kloop1996.bookva.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;
import android.widget.Toast;

import com.example.kloop1996.bookva.model.BookvaAplication;
import com.example.kloop1996.bookva.model.BookvaService;
import com.example.kloop1996.bookva.model.entity.AccessToken;
import com.example.kloop1996.bookva.model.entity.Author;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by kloop1996 on 12.05.2016.
 */
public class AuthorizationViewModel implements ViewModel {


    public ObservableField<String> login;
    public ObservableField<String> password;
    public ObservableInt progressVisibility;

    private Subscription subscription;
    private Context context;


    public AuthorizationViewModel(Context context){
        this.context = context;

        progressVisibility = new ObservableInt(View.INVISIBLE);
        login = new ObservableField<String>();
        password = new ObservableField<String>();

    }

    private void loginUser(String username,String password){
        final BookvaAplication bookvaAplication = BookvaAplication.get(context);
        BookvaService bookvaService = bookvaAplication.getBookvaService();

        subscription = bookvaService.getTokenAuthorization("password",username,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(bookvaAplication.defaultSubscribeScheduler())
                .subscribe(new Subscriber<AccessToken>() {
                    @Override
                    public void onCompleted() {
                        progressVisibility.set(View.INVISIBLE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(context,"Load error",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(AccessToken token) {

                        if (token.getToken()!=null){
                            bookvaAplication.setToken(token);

                        }

                    }
                });
    }

    public void onClickLogin(View view) {
        progressVisibility.set(View.VISIBLE);
        loginUser(login.get(),password.get());
    }

    @Override
    public void destroy() {
        context = null;
    }
}
