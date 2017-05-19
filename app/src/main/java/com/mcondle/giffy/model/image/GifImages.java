package com.mcondle.giffy.model.image;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mandeep.condle on 5/17/17.
 */

public class GifImages implements Parcelable {

    private OriginalImg original;
    @SerializedName("original_still") private OriginalStillImg originalStill;

    public GifImages() { }

    public GifImages(OriginalImg original, OriginalStillImg originalStill) {
        this.original = original;
        this.originalStill = originalStill;
    }

    public OriginalImg getOriginal() {
        return original;
    }

    public void setOriginal(OriginalImg original) {
        this.original = original;
    }

    public OriginalStillImg getOriginalStill() {
        return originalStill;
    }

    public void setOriginalStill(OriginalStillImg originalStill) {
        this.originalStill = originalStill;
    }

    // parcelable methods generated via http://www.parcelabler.com/

    protected GifImages(Parcel in) {
        original = (OriginalImg) in.readValue(BaseImg.class.getClassLoader());
        originalStill = (OriginalStillImg) in.readValue(BaseImg.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(original);
        dest.writeValue(originalStill);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<GifImages> CREATOR = new Parcelable.Creator<GifImages>() {
        @Override
        public GifImages createFromParcel(Parcel in) {
            return new GifImages(in);
        }

        @Override
        public GifImages[] newArray(int size) {
            return new GifImages[size];
        }
    };

}
