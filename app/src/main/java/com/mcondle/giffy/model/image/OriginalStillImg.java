package com.mcondle.giffy.model.image;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mandeep.condle on 5/17/17.
 */

public class OriginalStillImg extends BaseImg {

    String url;
    String width;
    String height;
    String size;

    public OriginalStillImg() { }

    public OriginalStillImg(String url, String width, String height, String size) {
        this.url = url;
        this.width = width;
        this.height = height;
        this.size = size;
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

    // parcelable methods generated via http://www.parcelabler.com/

    protected OriginalStillImg(Parcel in) {
        url = in.readString();
        width = in.readString();
        height = in.readString();
        size = in.readString();
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
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<OriginalStillImg> CREATOR = new Parcelable.Creator<OriginalStillImg>() {
        @Override
        public OriginalStillImg createFromParcel(Parcel in) {
            return new OriginalStillImg(in);
        }

        @Override
        public OriginalStillImg[] newArray(int size) {
            return new OriginalStillImg[size];
        }
    };

}


