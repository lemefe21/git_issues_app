package com.leme.gitissuesapp.main_activity;

import com.leme.gitissuesapp.api.ApiClient;
import com.leme.gitissuesapp.api.ApiInterface;
import com.leme.gitissuesapp.model.Issues;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainModel implements MainContract.Model {

    @Override
    public void getIssuesList(final OnFinishListener onFinishListener) {

        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);

        Call<List<Issues>> call = api.getIssuesList();
        call.enqueue(new Callback<List<Issues>>() {
            @Override
            public void onResponse(Call<List<Issues>> call, Response<List<Issues>> response) {

                List<Issues> issuesList = response.body();
                onFinishListener.onFinished(issuesList);

            }

            @Override
            public void onFailure(Call<List<Issues>> call, Throwable throwable) {

                onFinishListener.onFailure(throwable);

            }
        });

    }

}
