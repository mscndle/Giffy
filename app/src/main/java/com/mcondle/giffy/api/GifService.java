package com.mcondle.giffy.api;

import com.mcondle.giffy.model.GifListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mandeep.condle on 5/17/17.
 */

public interface GifService {

    static final String TRENDING_GIFS_URL = "/v1/gifs/trending";

    @GET(TRENDING_GIFS_URL)
    Call<GifListResponse> getTrendingGifs(
            @Query("api_key") String apiKey,
            @Query("limit") int limit);

}
