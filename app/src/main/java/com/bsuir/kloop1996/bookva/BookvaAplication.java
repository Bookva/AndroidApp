package com.bsuir.kloop1996.bookva;

import android.app.Application;
import android.content.Context;

import com.bsuir.kloop1996.bookva.core.BookvaService;
import com.bsuir.kloop1996.bookva.model.entity.AccessToken;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by kloop1996 on 09.05.2016.
 */
public class BookvaAplication extends Application {
    private BookvaService bookvaService;
    private AccessToken accessToken;
    private Scheduler defaultSubscribeScheduler;

    public static BookvaAplication get(Context context) {
        return (BookvaAplication) context.getApplicationContext();
    }

    public void AccessToken(AccessToken token){
        this.accessToken= token;
    }

    public AccessToken getAccessToken(){return accessToken;}

    public BookvaService getBookvaService() {
        if (bookvaService == null) {
            bookvaService = BookvaService.Factory.create();
        }
        return bookvaService;
    }

    public void setToken(AccessToken token){
        this.accessToken = token;
    }

    public AccessToken getToken(){
        return accessToken;
    }

    public Scheduler defaultSubscribeScheduler() {
        if (defaultSubscribeScheduler == null) {
            defaultSubscribeScheduler = Schedulers.io();
        }
        return defaultSubscribeScheduler;
    }

    //User to change scheduler from tests
    public void setDefaultSubscribeScheduler(Scheduler scheduler) {
        this.defaultSubscribeScheduler = scheduler;
    }
}
