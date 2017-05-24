package com.mcondle.giffy.presenter;

import com.mcondle.giffy.GiffyContract;
import com.mcondle.giffy.api.GifAdapter;
import com.mcondle.giffy.api.GifApi;
import com.mcondle.giffy.model.GifData;
import com.mcondle.giffy.model.GifListResponse;
import com.mcondle.giffy.model.image.GifImages;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mandeep.condle on 5/16/17.
 */

public class GifPresenter implements GiffyContract.Presenter {

    private GifAdapter gifAdapter;
    private GiffyContract.View gifListView;

    public GifPresenter(GifAdapter gifAdapter,
                        GiffyContract.View gifListView) {
        this.gifAdapter = gifAdapter;
        this.gifListView = gifListView;
    }

    @Override
    public void refresh(int items) {
        // make network request and populate the adapter
        GifApi api = new GifApi();

        gifListView.showLoading(true);
        Call<GifListResponse> call = api.getTrendingGifs(items);

        call.enqueue(new Callback<GifListResponse>() {
            @Override
            public void onResponse(Call<GifListResponse> call, Response<GifListResponse> response) {
                GifListResponse gifListResponse = response.body();

                gifAdapter.setData(getImageList(gifListResponse));
                gifListView.showLoading(false);
            }

            @Override
            public void onFailure(Call<GifListResponse> call, Throwable t) {
                gifListView.showErrorDialog();
            }
        });
    }

    private List<GifImages> getImageList(GifListResponse response) {
        List<GifImages> gifImgList = new ArrayList<>();
        GifData[] dataArr = response.getData();

        for (GifData data : dataArr) {
            gifImgList.add(data.getImages());
        }

        return gifImgList;
    }
}
