package com.sgs.javaretrofitproject.API;

import retrofit2.Call;
import retrofit2.http.POST;

public interface APIClient {

    @POST("")
    Call<DataServiceRow> getData();
}
