package com.leme.gitissuesapp.model;

import com.google.gson.annotations.SerializedName;

public class Issue {

    @SerializedName("url")
    private String url;

    @SerializedName("id")
    private long id;

    @SerializedName("title")
    private String title;

    @SerializedName("user")
    private User user;

    @SerializedName("state")
    private String state;

    @SerializedName("created_at")
    private String created_at;

    public Issue(String url, long id, String title, User user, String state, String created_at) {
        this.url = url;
        this.id = id;
        this.title = title;
        this.user = user;
        this.state = state;
        this.created_at = created_at;
    }

    public String getUrl() {
        return url;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }

    public String getState() {
        return state;
    }

    public String getCreated_at() {
        return created_at;
    }

}
