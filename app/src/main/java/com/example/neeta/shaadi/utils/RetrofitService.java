package com.example.neeta.shaadi.utils;

import com.example.neeta.shaadi.model.JsonResponseGetResult;
import com.example.neeta.shaadi.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Neeta on 10/9/2019.
 */

public interface RetrofitService {

    @Headers("Content-Type: application/json")
    @GET("/")
    Call<JsonResponseGetResult> getProfileList(@Query("results") int result);

}
