package com.mcondle.giffy.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mcondle.giffy.R;
import com.mcondle.giffy.api.GifApi;

/**
 * Created by mandeep.condle on 5/20/17.
 */

public class RandomGifFragment extends BaseFragment {

    SwipeRefreshLayout swipeRefreshLayout;
    ImageView gifImgView;

    GifApi api;

    public static RandomGifFragment newInstance() {
        return new RandomGifFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = new GifApi();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_random_gif, container, false);
        initUi(rootView);
        return rootView;
    }

    private void initUi(View rootView) {
    }

    @Override
    public void setupFab(View rootView) {
        // no-op
    }
}
