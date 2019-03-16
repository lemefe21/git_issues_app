package com.leme.gitissuesapp.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("login")
    private String login;

    @SerializedName("avatar_url")
    private String avatar_url;

    public User(String login, String avatar_url) {
        this.login = login;
        this.avatar_url = avatar_url;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

}
