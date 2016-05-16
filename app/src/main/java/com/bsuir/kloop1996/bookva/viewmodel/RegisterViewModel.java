package com.bsuir.kloop1996.bookva.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.bsuir.kloop1996.bookva.BookvaAplication;
import com.bsuir.kloop1996.bookva.R;
import com.bsuir.kloop1996.bookva.core.BookvaService;
import com.bsuir.kloop1996.bookva.model.entity.AccessToken;
import com.bsuir.kloop1996.bookva.model.entity.Profile;
import com.bsuir.kloop1996.bookva.ui.view.activity.MainActivity;

import okhttp3.ResponseBody;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by kloop1996 on 16.05.2016.
 */
public class RegisterViewModel implements ViewModel {
    public ObservableField<String> loginField;
    public ObservableField<String> passwordField;
    public ObservableField<String> emailField;
    public ObservableInt progressVisibility;

    private Subscription subscription;
    private Context context;
    private String login;
    private String password;
    private String email;


    public RegisterViewModel(Context context) {
        this.context = context;

        progressVisibility = new ObservableInt(View.INVISIBLE);
        loginField = new ObservableField<String>();
        passwordField = new ObservableField<String>();
        emailField = new ObservableField<String>();


    }

    private void registerUser(Profile profile) {
        final BookvaAplication bookvaAplication = BookvaAplication.get(context);
        BookvaService bookvaService = bookvaAplication.getBookvaService();

        if (subscription != null && !subscription.isUnsubscribed()) subscription.unsubscribe();

        subscription = bookvaService.registerUser(profile)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(bookvaAplication.defaultSubscribeScheduler())
                .subscribe(new Subscriber<ResponseBody>() {
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
                    public void onNext(ResponseBody responseBody) {
                        Toast.makeText(context, "Регистрация прошла успешна", Toast.LENGTH_LONG).show();
                        MainActivity.getIntstanse().callbackRegisterUser();
                    }
                });
    }

    public void onClickRegister(View view) {
        progressVisibility.set(View.VISIBLE);
        Profile profile = new Profile(login,password,email);
        registerUser(profile);
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

    public TextWatcher getEmailEditTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                email = charSequence.toString();
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
