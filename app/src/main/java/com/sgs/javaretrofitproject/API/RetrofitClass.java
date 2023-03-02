package com.sgs.javaretrofitproject.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sgs.javaretrofitproject.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {
    private static Retrofit retrofit;
    public static Retrofit getInstance(){
        if(retrofit == null){
            Gson gsonBuilder= new GsonBuilder().setLenient().create();
            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
            HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
            if(BuildConfig.DEBUG)
                okHttpClient.addInterceptor(loggingInterceptor);
            retrofit=new Retrofit.Builder().baseUrl("").addConverterFactory(GsonConverterFactory.create(gsonBuilder)).client(okHttpClient.build()).build();
        }
        return retrofit;
    }
}
