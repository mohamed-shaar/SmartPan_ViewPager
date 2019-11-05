package com.example.smartpan_2_11.model;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("photos")
    Call<ArrayList<ResponseEntity>> getResponse();
}
