package com.mcondle.giffy.model;

/**
 * Created by mandeep.condle on 5/16/17.
 */

public class GifListResponse {

    private GifData[] data;
    private Pagination pagination;
    private Meta meta;

    public GifListResponse() { }

    public GifListResponse(GifData[] data, Pagination pagination, Meta meta) {
        this.data = data;
        this.pagination = pagination;
        this.meta = meta;
    }

    public GifData[] getData() {
        return data;
    }

    public void setData(GifData[] data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
