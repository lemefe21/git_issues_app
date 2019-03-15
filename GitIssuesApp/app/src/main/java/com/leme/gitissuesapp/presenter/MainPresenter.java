package com.leme.gitissuesapp.presenter;

import com.leme.gitissuesapp.contract.MainContract;
import com.leme.gitissuesapp.handler.ExceptionHandler;
import com.leme.gitissuesapp.service.MainService;
import com.leme.gitissuesapp.model.Issues;

import java.util.List;

import retrofit2.HttpException;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter, MainContract.Service.RequestListener {

    private MainContract.MainView view;
    private MainContract.Service service;

    public MainPresenter(MainContract.MainView view) {
        this.view = view;
        service = new MainService();
    }

    @Override
    public void success(List<Issues> issuesList) {
        view.setDataToRecyclerView(issuesList);
        view.hideProgress();

    }

    @Override
    public void error(Throwable throwable) {
        view.showError(ExceptionHandler.FormatErrorToUi(throwable));
        view.hideProgress();
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }

    @Override
    public void requestDataFromServer() {
        view.showProgress();
        try {
            service.getIssues(this);
        } catch (Exception exception) {
            view.hideProgress();
            this.view.showError(ExceptionHandler.FormatErrorToUi(exception));
        }
    }
}
