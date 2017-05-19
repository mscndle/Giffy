package com.mcondle.giffy.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.mcondle.giffy.model.image.GifImages;

/**
 * Created by mandeep.condle on 5/16/17.
 */

public class GifData implements Parcelable {

    // unused properties ignored
    String type;
    String id;
    String url;
    GifImages images;

    public GifData() { }

    public GifData(String type, String id, String url, GifImages images) {
        this.type = type;
        this.id = id;
        this.url = url;
        this.images = images;
    }

    public GifImages getImages() {
        return images;
    }

    public void setImages(GifImages images) {
        this.images = images;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // parcelable methods generated via http://www.parcelabler.com/

    protected GifData(Parcel in) {
        type = in.readString();
        id = in.readString();
        url = in.readString();
        images = (GifImages) in.readValue(GifImages.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(id);
        dest.writeString(url);
        dest.writeValue(images);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<GifData> CREATOR = new Parcelable.Creator<GifData>() {
        @Override
        public GifData createFromParcel(Parcel in) {
            return new GifData(in);
        }

        @Override
        public GifData[] newArray(int size) {
            return new GifData[size];
        }
    };

}
