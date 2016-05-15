package com.bsuir.kloop1996.bookva.core;

import com.bsuir.kloop1996.bookva.model.entity.AccessToken;
import com.bsuir.kloop1996.bookva.model.entity.Author;
import com.bsuir.kloop1996.bookva.model.entity.Genre;
import com.bsuir.kloop1996.bookva.model.entity.Profile;
import com.bsuir.kloop1996.bookva.model.entity.Work;

import java.util.List;

import okhttp3.ResponseBody;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kloop1996 on 17.04.2016.
 */
public interface BookvaService {

    @Headers({
            "Content-type : application/json"
    })
    @GET("/api/authors")
    public rx.Observable<List<Author>> getAuthors();

    @Headers({
            "Content-type : application/json"
    })
    @GET("/api/authors/{id}")
    public rx.Observable<Author> getAuthor(@Path("id") int id);


    @Headers({
            "Content-type : application/json"
    })
    @GET("api/genres/")
    public rx.Observable<List<Genre>> getGenres();


    @Headers({
            "Content-type : application/x-www-form-urlencoded"
    })
    @FormUrlEncoded
    @POST("/Token")
    public rx.Observable<AccessToken> getTokenAuthorization(@Field("grant_type") String grantType, @Field("username") String login, @Field("password") String password);


    @POST("/api/account/register")
    public rx.Observable<ResponseBody> registerUser(@Body Profile profile);

    @Headers({
            "Content-type : application/x-www-form-urlencoded"
    })
    @GET("api/works")
    public rx.Observable<List<Work>> getAllWorks();

    class Factory {
        public static BookvaService create() {
            Retrofit retrofit;
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://test-bookva.azurewebsites.net")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(BookvaService.class);
        }
    }

}
