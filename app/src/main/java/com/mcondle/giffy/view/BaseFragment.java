package com.mcondle.giffy.view;

import android.support.v4.app.Fragment;
import android.view.View;

import com.mcondle.giffy.GiffyContract;

public abstract class BaseFragment extends Fragment implements
        GiffyContract.Navigator, GiffyContract.View {

    protected static final int MIN_RANDOM_ITEMS = 10;
    protected static final int MAX_RANDOM_ITEMS = 50;

    public abstract void setupFab(View rootView);

    public GifActivity getGifActivity() {
        return (GifActivity) getActivity();
    }

    @Override
    public void launchDetailView(String url) {
        getGifActivity().launchDetailView(url);
    }

    @Override
    public void showLoading(boolean show) {
        GifActivity activity = getGifActivity();
        if (show) activity.showLoading(true);
        else activity.showLoading(false);
    }

    @Override
    public void showErrorDialog() {
        getGifActivity().showErrorDialog();
    }

    protected int randomItems() {
        return (int) (Math.random() * MAX_RANDOM_ITEMS + MIN_RANDOM_ITEMS);
    }
}
