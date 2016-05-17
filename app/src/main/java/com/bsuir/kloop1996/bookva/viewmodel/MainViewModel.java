package com.bsuir.kloop1996.bookva.viewmodel;

import android.content.Context;

/**
 * Created by kloop1996 on 16.05.2016.
 */
public class MainViewModel implements ViewModel {

    private Context context;


    public MainViewModel (Context context){
        this.context= context;
    }

    @Override
    public void destroy() {
        context=null;
    }
}
