package com.leme.gitissuesapp.service;

import com.leme.gitissuesapp.api.ApiClient;
import com.leme.gitissuesapp.api.ApiInterface;
import com.leme.gitissuesapp.contract.MainContract;
import com.leme.gitissuesapp.model.Issues;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainService implements MainContract.Service {

    @Override
    public void getIssues(final RequestListener requestListener) {

        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);

        Call<List<Issues>> call = api.getIssuesList();
        call.enqueue(new Callback<List<Issues>>() {
            @Override
            public void onResponse(Call<List<Issues>> call, Response<List<Issues>> response) {

                List<Issues> issuesList = response.body();
                requestListener.success(issuesList);

            }

            @Override
            public void onFailure(Call<List<Issues>> call, Throwable throwable) {

                requestListener.error(throwable);

            }
        });

    }

}
