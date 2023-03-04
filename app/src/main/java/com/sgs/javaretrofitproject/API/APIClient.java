package com.sgs.javaretrofitproject.API;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIClient {

    @FormUrlEncoded
    @POST("JAVARetrofitWithPHPAPIService/index.php")
    Call<DataServiceRow> getData(
            @Field("Manager") String Manager
    );

    @FormUrlEncoded
    @POST("JAVARetrofitWithPHPAPIService/index.php")
    Call<DataServiceRow> ManageNews(
            @Field("Manager") String Manager,
            @Field("id") Integer ID,
            @Field("name") String Name,
            @Field("description") String Description
    );
}
