package com.mcondle.giffy.api;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mcondle.giffy.GiffyContract;
import com.mcondle.giffy.R;
import com.mcondle.giffy.model.image.GifImages;
import com.mcondle.giffy.model.image.OriginalStillImg;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mandeep.condle on 5/24/17.
 */

public class StickerAdapter extends RecyclerView.Adapter<StickerAdapter.StickerViewHolder> {

    private Context context;
    private List<GifImages> images;
    private GiffyContract.Navigator navigator;

    public StickerAdapter(Context context, GiffyContract.Navigator navigator) {
        this.context = context;
        this.navigator = navigator;
        this.images = new ArrayList<>();
    }

    public StickerAdapter(Context context, GiffyContract.Navigator navigator,
                      List<GifImages> images) {
        this.context = context;
        this.navigator = navigator;
        this.images = images;
    }

    @Override
    public StickerAdapter.StickerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View gifView = inflater.inflate(R.layout.sticker_view, parent, false);

        return new StickerAdapter.StickerViewHolder(context, navigator, gifView);
    }

    @Override
    public void onBindViewHolder(StickerAdapter.StickerViewHolder holder, int position) {
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

    static class StickerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        ImageView imageView;
        GiffyContract.Navigator navigator;
        GifImages images;

        StickerViewHolder(Context context, GiffyContract.Navigator navigator, View itemView) {
            super(itemView);
            this.context = context;
            this.navigator = navigator;
            this.imageView = (ImageView) itemView.findViewById(R.id.sticker_img_view);
            this.imageView.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }

        void setGifImages(GifImages images) {
            this.images = images;
            OriginalStillImg img = images.getOriginalStill();
            String imgUrl = img.getUrl();
            Picasso.with(context).load(imgUrl).into(imageView);
        }

        @Override
        public void onClick(View v) {
            navigator.launchDetailView(images.getOriginal().getUrl());
        }
    }
}
