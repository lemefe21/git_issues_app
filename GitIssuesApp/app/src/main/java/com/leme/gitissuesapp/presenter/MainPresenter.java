package com.leme.gitissuesapp.presenter;

import com.leme.gitissuesapp.contract.MainContract;
import com.leme.gitissuesapp.service.MainService;
import com.leme.gitissuesapp.model.Issues;

import java.util.List;

public class MainPresenter implements MainContract.Presenter, MainContract.Service.RequestListener {

    private MainContract.View view;
    private MainContract.Service service;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        service = new MainService();
    }

    @Override
    public void success(List<Issues> issuesList) {
        view.setDataToRecyclerView(issuesList);
        if(view != null) {
            view.hideProgress();
        }
    }

    @Override
    public void error(Throwable throwable) {
        view.onResponseFailure(throwable);
        if(view != null) {
            view.hideProgress();
        }
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }

    @Override
    public void requestDataFromServer() {
        if(view != null) {
            view.showProgress();
        }
        service.getIssues(this);
    }
}
