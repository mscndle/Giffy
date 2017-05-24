package com.mcondle.giffy.api;

import com.mcondle.giffy.model.GifListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mandeep.condle on 5/17/17.
 */

public interface GifService {

    String TRENDING_GIFS_URL = "/v1/gifs/trending";
    String TRENDING_STICKERS_URL = "/v1/stickers/trending";
    String RANDOM_GIF_URL = "/v1/gifs/random";

    @GET(TRENDING_GIFS_URL)
    Call<GifListResponse> getTrendingGifs(
            @Query("api_key") String apiKey,
            @Query("limit") int limit);

    @GET(TRENDING_STICKERS_URL)
    Call<GifListResponse> getTrendingStickers(
            @Query("api_key") String apiKey,
            @Query("limit") int limit);

    @GET(RANDOM_GIF_URL)
    Call<GifListResponse> getRandomGif(
            @Query("api_key") String apiKey);

}
