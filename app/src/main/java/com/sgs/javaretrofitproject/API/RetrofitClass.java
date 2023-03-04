package com.sgs.javaretrofitproject.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {
    private static Retrofit retrofit;
    private RetrofitClass(){

    }
    public static Retrofit getInstance(){
        if(retrofit == null){
            Gson gsonBuilder= new GsonBuilder().setLenient().create();
            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
            okHttpClient.connectTimeout(100, TimeUnit.SECONDS);
            HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
            loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
//            if(BuildConfig.DEBUG)
                okHttpClient.addInterceptor(loggingInterceptor);
            retrofit=new Retrofit.Builder().baseUrl("http://192.168.0.196:80/").addConverterFactory(GsonConverterFactory.create(gsonBuilder)).client(okHttpClient.build()).build();
//            retrofit=new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gsonBuilder)).baseUrl("http://192.168.0.196:8080/").build();
        }
        return retrofit;
    }
}
