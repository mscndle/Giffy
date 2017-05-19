package com.mcondle.giffy.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mandeep.condle on 5/16/17.
 */

public class Meta implements Parcelable {

    public int status;
    public String msg;

    public Meta() { }

    public Meta(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    // parcelable methods generated via http://www.parcelabler.com/

    protected Meta(Parcel in) {
        status = in.readInt();
        msg = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(status);
        dest.writeString(msg);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Meta> CREATOR = new Parcelable.Creator<Meta>() {
        @Override
        public Meta createFromParcel(Parcel in) {
            return new Meta(in);
        }

        @Override
        public Meta[] newArray(int size) {
            return new Meta[size];
        }
    };

}
