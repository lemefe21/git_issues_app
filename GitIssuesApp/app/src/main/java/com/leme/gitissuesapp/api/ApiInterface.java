package com.leme.gitissuesapp.api;

import com.leme.gitissuesapp.model.Issues;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/repos/JetBrains/kotlin/issues")
    Call<List<Issues>> getIssuesList();

}
