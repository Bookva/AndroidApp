package com.example.kloop1996.bookva;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.kloop1996.bookva.R;
import com.example.kloop1996.bookva.model.BookvaAplication;
import com.example.kloop1996.bookva.model.BookvaService;
import com.example.kloop1996.bookva.model.entity.Author;
import com.example.kloop1996.bookva.model.entity.Work;
import com.example.kloop1996.bookva.view.AuthorizationFragment;
import com.example.kloop1996.bookva.view.WorkFragment;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {
    private Subscription subscription;
    private Drawer drawer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(R.string.app_name);


        drawer = new DrawerBuilder(this)
                .withRootView(R.id.drawer_container)
                .withHeader(R.layout.header)
                .withToolbar(toolbar)
                .withCloseOnClick(true)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.login).withIcon(R.drawable.ic_account).withTextColorRes(R.color.black),
                        new PrimaryDrawerItem().withName(R.string.login).withIcon(R.drawable.ic_account).withTextColorRes(R.color.black)
                )
                .withSavedInstance(savedInstanceState).build();

        if (savedInstanceState == null) {

            FragmentTransaction tx = getFragmentManager()
                    .beginTransaction();

            tx.add(R.id.container_layout, new WorkFragment());
            tx.addToBackStack(null);
            tx.commit();

        }

//        final BookvaAplication bookvaAplication = BookvaAplication.get(this);
//        BookvaService bookvaService = bookvaAplication.getBookvaService();
//      /*  Call<List<Author>>  call = bookvaService.getAuthors();
//        Call<Author> callAuthor = bookvaService.getAuthor(4);
//        Call<List<Genre>> callListGenre = bookvaService.getGenres();
//        Call<AccessToken> call1 = bookvaService.getTokenAuthorization("password","Kloop1996","Awdrg1234");
//        Call<ResponseBody> call2 = bookvaService.registerUser(new Profile("Kloop1998","Awdrg1234","shamyna.artem@mail.ru"));
//
//        callListGenre.enqueue(new Callback<List<Genre>>() {
//            @Override
//            public void onResponse(Call<List<Genre>> call, Response<List<Genre>> response) {
//                List<Genre> list = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<List<Genre>> call, Throwable t) {
//
//            }
//        });
//
//        callAuthor.enqueue(new Callback<Author>() {
//            @Override
//            public void onResponse(Call<Author> call, Response<Author> response) {
//                Author author = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<Author> call, Throwable t) {
//                t.hashCode();
//            }
//        });
//
//        call.enqueue(new Callback<List<Author>>() {
//            @Override
//            public void onResponse(Call<List<Author>> call, Response<List<Author>> response) {
//                List<Author> authors = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<List<Author>> call, Throwable t) {
//                    call=call;
//                    call.hashCode();
//            }
//        });
//
//
//        call1.enqueue(new Callback<AccessToken>() {
//            @Override
//            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
//                  AccessToken lal=  response.body();
//            }
//
//            @Override
//            public void onFailure(Call<AccessToken> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
//
//
//        call2.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//              Headers headers=  response.headers();
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });*/
//
//       subscription = bookvaService.getAuthors()
//               .observeOn(AndroidSchedulers.mainThread())
//               .subscribeOn(bookvaAplication.defaultSubscribeScheduler())
//               .subscribe(new Subscriber<List<Author>>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Toast.makeText(bookvaAplication,"Load error",Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onNext(List<Author> authors) {
//                        List<Author> aut = authors;
//                        Toast.makeText(bookvaAplication,"Load",Toast.LENGTH_LONG).show();
//
//                    }
//        });
//        subscription = bookvaService.getAllWorks()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(bookvaAplication.defaultSubscribeScheduler())
//                .subscribe(new Subscriber<List<Work>>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Toast.makeText(bookvaAplication, "Load error", Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onNext(List<Work> authors) {
//                        List<Work> aut = authors;
//                        Toast.makeText(bookvaAplication, "Load", Toast.LENGTH_LONG).show();
//
//                    }
//                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (subscription != null) subscription.unsubscribe();
    }

}
