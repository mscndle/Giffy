package com.mcondle.giffy.view;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class GifFragmentPagerAdapter extends FragmentPagerAdapter {

    private static final int NUM_FRAGMENTS = 3;

    public GifFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
//                Log.d("Giffy", "position:" + position + " in GifFragmentPagerAdapter");
                return GifGridFragment.newInstance();
            case 1:
//                Log.d("Giffy", "position:" + position + " in GifFragmentPagerAdapter");
                return StickerListFragment.newInstance();
            case 2:
//                Log.d("Giffy", "position:" + position + " in GifFragmentPagerAdapter");
                return RandomGifFragment.newInstance();
        }

        return null;
    }

    @Override
    public int getCount() {
        return NUM_FRAGMENTS;
    }
}
