package com.mcondle.giffy.api;

import com.mcondle.giffy.model.GifListResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mandeep.condle on 5/17/17.
 */

public class GifApi {

    static final String BASE_URL = "http://api.giphy.com";
    static final String API_KEY = "dc6zaTOxFJmzC";

    Retrofit retrofit;
    GifService apiService;

    public GifApi() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = this.retrofit.create(GifService.class);
    }

    public Call<GifListResponse> getTrendingGifs() {
        return apiService.getTrendingGifs(API_KEY, getRandomLimit());
    }

    public Call<GifListResponse> getTrendingGifs(int count) {
        return apiService.getTrendingGifs(API_KEY, count);
    }

    private int getRandomLimit() {
        return (int )(Math.random() * 50 + 1);
    }

}
