package com.mcondle.giffy.model.image;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mandeep.condle on 5/17/17.
 */

public class OriginalImg extends BaseImg {

    private String url;
    private String width;
    private String height;
    private String size;
    private String frames;
    private String mp4;
    @SerializedName("mp4_size") private String mp4Size;
    private String webp;
    @SerializedName("webp_size") private String webpSize;
    private String hash;

    public OriginalImg() { }

    public OriginalImg(String url, String width, String height, String size, String frames, String mp4,
                       String mp4Size, String webp, String webpSize, String hash) {
        this.url = url;
        this.width = width;
        this.height = height;
        this.size = size;
        this.frames = frames;
        this.mp4 = mp4;
        this.mp4Size = mp4Size;
        this.webp = webp;
        this.webpSize = webpSize;
        this.hash = hash;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFrames() {
        return frames;
    }

    public void setFrames(String frames) {
        this.frames = frames;
    }

    public String getMp4() {
        return mp4;
    }

    public void setMp4(String mp4) {
        this.mp4 = mp4;
    }

    public String getMp4Size() {
        return mp4Size;
    }

    public void setMp4Size(String mp4Size) {
        this.mp4Size = mp4Size;
    }

    public String getWebp() {
        return webp;
    }

    public void setWebp(String webp) {
        this.webp = webp;
    }

    public String getWebpSize() {
        return webpSize;
    }

    public void setWebpSize(String webpSize) {
        this.webpSize = webpSize;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    // parcelable methods generated via http://www.parcelabler.com/

    protected OriginalImg(Parcel in) {
        url = in.readString();
        width = in.readString();
        height = in.readString();
        size = in.readString();
        frames = in.readString();
        mp4 = in.readString();
        mp4Size = in.readString();
        webp = in.readString();
        webpSize = in.readString();
        hash = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(width);
        dest.writeString(height);
        dest.writeString(size);
        dest.writeString(frames);
        dest.writeString(mp4);
        dest.writeString(mp4Size);
        dest.writeString(webp);
        dest.writeString(webpSize);
        dest.writeString(hash);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<OriginalImg> CREATOR = new Parcelable.Creator<OriginalImg>() {
        @Override
        public OriginalImg createFromParcel(Parcel in) {
            return new OriginalImg(in);
        }

        @Override
        public OriginalImg[] newArray(int size) {
            return new OriginalImg[size];
        }
    };

}
