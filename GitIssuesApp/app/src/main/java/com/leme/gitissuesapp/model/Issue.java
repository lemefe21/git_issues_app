package com.leme.gitissuesapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Issue implements Parcelable {

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

    @SerializedName("body")
    private String body;

    public Issue(Parcel in) {
        this.url = in.readString();
        this.id = in.readLong();
        this.title = in.readString();
        this.user = in.readParcelable(User.class.getClassLoader());
        this.state = in.readString();
        this.created_at = in.readString();
        this.body = in.readString();
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

    public String getBody() {
        return body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(url);
        parcel.writeLong(id);
        parcel.writeString(title);
        parcel.writeParcelable(user, flags);
        parcel.writeString(state);
        parcel.writeString(created_at);
        parcel.writeString(body);
    }

    static Parcelable.Creator<Issue> CREATOR = new Parcelable.Creator<Issue>() {
        @Override
        public Issue createFromParcel(Parcel parcel) {
            return new Issue(parcel);
        }

        @Override
        public Issue[] newArray(int i) {
            return new Issue[i];
        }
    };

}
