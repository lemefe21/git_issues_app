package com.leme.gitissuesapp.model;

import com.google.gson.annotations.SerializedName;

public class Issues {

    @SerializedName("id")
    private long id;

    public Issues(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
