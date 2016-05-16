package com.bsuir.kloop1996.bookva.ui.view.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bsuir.kloop1996.bookva.R;
import com.bsuir.kloop1996.bookva.databinding.BookDetailActivityBinding;
import com.bsuir.kloop1996.bookva.viewmodel.BookDetailViewModel;
import com.bumptech.glide.Glide;

/**
 * Created by kloop1996 on 16.05.2016.
 */
public class BookDetailActivity extends AppCompatActivity {
    public static final String EXTRA_ID_WORK = "work_id";
    public static final String EXTRA_TITLE = "title";

    private BookDetailActivityBinding binding;
    private BookDetailViewModel bookDetailViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.book_detail_activity);
        bookDetailViewModel = new BookDetailViewModel(this,getIntent().getExtras().getInt(BookDetailActivity.EXTRA_ID_WORK));

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.collapsingToolbar.setTitle(getIntent().getExtras().getString(BookDetailActivity.EXTRA_TITLE));

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(getIntent().getExtras().getString(BookDetailActivity.EXTRA_TITLE));



        Glide.with(this).load(R.drawable.placeholder2).centerCrop().into(binding.backdrop);

        binding.setViewModel(bookDetailViewModel);


    }
}
