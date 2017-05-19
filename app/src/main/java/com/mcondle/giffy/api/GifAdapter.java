package com.mcondle.giffy.api;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mcondle.giffy.R;
import com.mcondle.giffy.model.image.GifImages;
import com.mcondle.giffy.model.image.OriginalStillImg;
import com.mcondle.giffy.ui.GifListContract;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mandeep.condle on 5/17/17.
 */

public class GifAdapter extends RecyclerView.Adapter<GifAdapter.GifViewHolder> {

    private static final int FIXED_WIDTH = 700;
    private static final int FIXED_HEIGHT = 420;

    private Context context;
    private List<GifImages> images;
    private GifListContract.Navigator navigator;

    public GifAdapter(Context context, GifListContract.Navigator navigator) {
        this.context = context;
        this.navigator = navigator;
        this.images = new ArrayList<>();
    }

    public GifAdapter(Context context, GifListContract.Navigator navigator,
                      List<GifImages> images) {
        this.context = context;
        this.navigator = navigator;
        this.images = images;
    }

    @Override
    public GifViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View gifView = inflater.inflate(R.layout.gif_view, parent, false);

        return new GifViewHolder(context, navigator, gifView);
    }

    @Override
    public void onBindViewHolder(GifViewHolder holder, int position) {
        GifImages images = getItem(position);
        holder.setGifImages(images);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public void setData(List<GifImages> images) {
        this.images.clear();
        this.images.addAll(images);
        notifyDataSetChanged();
    }

    private GifImages getItem(int position) {
        return images.get(position);
    }

    static class GifViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        ImageView imageView;
        GifListContract.Navigator navigator;
        GifImages images;

        GifViewHolder(Context context, GifListContract.Navigator navigator, View itemView) {
            super(itemView);
            this.context = context;
            this.navigator = navigator;
            this.imageView = (ImageView) itemView.findViewById(R.id.gif_img_view);
            this.imageView.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }

        void setGifImages(GifImages images) {
            this.images = images;
            OriginalStillImg img = images.getOriginalStill();
            String imgUrl = img.getUrl();
            Picasso.with(context).load(imgUrl).resize(FIXED_WIDTH, FIXED_HEIGHT).centerCrop().into(imageView);
        }

        @Override
        public void onClick(View v) {
            navigator.launchDetailView(images.getOriginal().getUrl());
        }
    }

}
