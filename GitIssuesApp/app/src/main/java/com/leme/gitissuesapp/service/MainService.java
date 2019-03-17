package com.leme.gitissuesapp.service;

import com.leme.gitissuesapp.api.ApiClient;
import com.leme.gitissuesapp.api.ApiInterface;
import com.leme.gitissuesapp.contract.MainContract;
import com.leme.gitissuesapp.model.Issue;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainService implements MainContract.Service {

    @Override
    public void getIssues(final RequestListener requestListener) {

        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);

        Call<List<Issue>> call = api.getIssuesList();
        call.enqueue(new Callback<List<Issue>>() {
            @Override
            public void onResponse(Call<List<Issue>> call, Response<List<Issue>> response) {

                List<Issue> issuesList = response.body();
                requestListener.success(issuesList);

            }

            @Override
            public void onFailure(Call<List<Issue>> call, Throwable throwable) {

                requestListener.error(throwable);

            }
        });

    }

}
