package com.example.kloop1996.bookva;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
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
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {
    private final static String AUTHORIZATION_FRAGMENT = "authorization";
    private final static String WORK_LIST_FRAGMENT = "feed";
    private final static String LOGOUT_TAG= "logout";

    private Subscription subscription;
    private Drawer drawer = null;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInstance = this;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
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
                        new PrimaryDrawerItem().withName(R.string.feed).withIcon(R.drawable.ic_book_open_page_variant).withTag("feed"),
                        new PrimaryDrawerItem().withName(R.string.login).withIcon(R.drawable.ic_account).withTag("authorization")
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        changeFragment((String)drawerItem.getTag());
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState).build();

        if (savedInstanceState == null) {

            FragmentTransaction tx = getFragmentManager()
                    .beginTransaction();

            tx.add(R.id.container_layout, new WorkFragment(),WORK_LIST_FRAGMENT);
            tx.addToBackStack(null);
            tx.commit();

        }
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

    private void changeFragment(String tag){
        FragmentTransaction tx;
        Fragment fragment;

        switch (tag){
            case AUTHORIZATION_FRAGMENT:
                AuthorizationFragment authorizationFragment = (AuthorizationFragment) getFragmentManager().findFragmentByTag(AUTHORIZATION_FRAGMENT);

                if (authorizationFragment != null && authorizationFragment.isVisible()) {
                    break;
                }


                tx = getFragmentManager()
                        .beginTransaction();

                fragment = new AuthorizationFragment();

                tx.replace(R.id.container_layout, fragment, AUTHORIZATION_FRAGMENT);
                tx.addToBackStack(null);

                tx.commit();
                break;
            case WORK_LIST_FRAGMENT:
                WorkFragment workFragment = (WorkFragment) getFragmentManager().findFragmentByTag(WORK_LIST_FRAGMENT);

                if (workFragment != null && workFragment.isVisible()) {
                    break;
                }


                tx = getFragmentManager()
                        .beginTransaction();

                fragment = new  WorkFragment();

                tx.replace(R.id.container_layout, fragment, WORK_LIST_FRAGMENT);
                tx.addToBackStack(null);

                tx.commit();
                break;

            case LOGOUT_TAG:
                BookvaAplication bookvaAplication = BookvaAplication.get(this);
                bookvaAplication.setToken(null);

                loadDrawer();

                break;
        }
    }

    public void loadDrawer(){
        BookvaAplication bookvaAplication = BookvaAplication.get(this);
        drawer.removeAllItems();

        if (bookvaAplication.getToken()!=null){
            drawer.addItems(
                    new PrimaryDrawerItem().withName(R.string.feed).withIcon(R.drawable.ic_book_open_page_variant).withTag("feed"),
                    new SectionDrawerItem().withName(R.string.account),
                    new SecondaryDrawerItem().withName(R.string.logout).withIcon(R.drawable.ic_logout_variant).withTag("logout")
            );
        }else{
            drawer.addItems(
                    new PrimaryDrawerItem().withName(R.string.feed).withIcon(R.drawable.ic_book_open_page_variant).withTag("feed"),
                    new PrimaryDrawerItem().withName(R.string.login).withIcon(R.drawable.ic_account).withTag("authorization")
            );
        }
    }

    private static MainActivity mInstance;

    public static MainActivity getIntstanse(){
        return mInstance;
    }

}
