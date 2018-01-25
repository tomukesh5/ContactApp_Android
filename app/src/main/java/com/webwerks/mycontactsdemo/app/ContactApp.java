package com.webwerks.mycontactsdemo.app;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.webwerks.mycontactsdemo.R;
import com.webwerks.mycontactsdemo.webservices.IWebServicesAPI;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by webwerks on 25/01/18.
 */

public class ContactApp extends Application{

    private static ContactApp contactApp;
    private Retrofit retrofit;
    private Gson gson;
    private IWebServicesAPI api;

    public static ContactApp instance() {
        return contactApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        contactApp=this;
        gson = new GsonBuilder().setLenient().create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(15, TimeUnit.SECONDS).build();
        retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.BASE_URL))
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        api = retrofit.create(IWebServicesAPI.class);

    }

    public IWebServicesAPI getApi() {
        return api;
    }

}
