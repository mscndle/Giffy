package com.mcondle.giffy.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mandeep.condle on 5/16/17.
 */

public class Pagination implements Parcelable {

    public int count;
    public int offset;

    public Pagination() { }

    public Pagination(int count, int offset) {
        this.count = count;
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    // parcelable methods generated via http://www.parcelabler.com/

    protected Pagination(Parcel in) {
        count = in.readInt();
        offset = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(count);
        dest.writeInt(offset);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Pagination> CREATOR = new Parcelable.Creator<Pagination>() {
        @Override
        public Pagination createFromParcel(Parcel in) {
            return new Pagination(in);
        }

        @Override
        public Pagination[] newArray(int size) {
            return new Pagination[size];
        }
    };

}
