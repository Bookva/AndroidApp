package com.example.kloop1996.bookva.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.kloop1996.bookva.R;
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


    public ObservableField<String> loginField;
    public ObservableField<String> passwordField;
    public ObservableInt progressVisibility;

    private Subscription subscription;
    private Context context;
    private String login;
    private String password;


    public AuthorizationViewModel(Context context) {
        this.context = context;

        progressVisibility = new ObservableInt(View.INVISIBLE);
        loginField = new ObservableField<String>();
        passwordField = new ObservableField<String>();


    }

    private void loginUser(String username, String password) {
        final BookvaAplication bookvaAplication = BookvaAplication.get(context);
        BookvaService bookvaService = bookvaAplication.getBookvaService();

        if (subscription != null && !subscription.isUnsubscribed()) subscription.unsubscribe();

        subscription = bookvaService.getTokenAuthorization("password", username, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(bookvaAplication.defaultSubscribeScheduler())
                .subscribe(new Subscriber<AccessToken>() {
                    @Override
                    public void onCompleted() {
                        progressVisibility.set(View.INVISIBLE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(context, context.getResources().getText(R.string.authorization_error), Toast.LENGTH_LONG).show();
                        progressVisibility.set(View.INVISIBLE);
                    }

                    @Override
                    public void onNext(AccessToken token) {

                        if (token.getToken() != null) {
                            bookvaAplication.setToken(token);
                            Toast.makeText(context, context.getResources().getText(R.string.authorization_success), Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(context, context.getResources().getText(R.string.authorization_wrong_password), Toast.LENGTH_LONG).show();
                        }

                    }
                });
    }

    public void onClickLogin(View view) {
        progressVisibility.set(View.VISIBLE);

        loginUser(login, password);
    }


    public TextWatcher getLoginEditTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                login = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };
    }

    public TextWatcher getPasswordEditTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                password = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };
    }

    @Override
    public void destroy() {
        if (subscription != null && !subscription.isUnsubscribed()) subscription.unsubscribe();
        subscription = null;
        context = null;
    }
}
