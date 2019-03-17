package com.leme.gitissuesapp.presenter;

import android.content.Intent;

import com.leme.gitissuesapp.contract.MainContract;
import com.leme.gitissuesapp.handler.ExceptionHandler;
import com.leme.gitissuesapp.service.MainService;
import com.leme.gitissuesapp.model.Issue;
import com.leme.gitissuesapp.view.activity.IssueDetailActivity;
import com.leme.gitissuesapp.view.activity.MainActivity;

import java.util.List;

public class MainPresenter implements MainContract.Presenter, MainContract.Service.RequestListener {

    public static final String ISSUE = "main_list_issue_clicked";
    private MainContract.View view;
    private MainContract.Service service;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        service = new MainService();
    }

    @Override
    public void success(List<Issue> issuesList) {
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
            this.view.showError(ExceptionHandler.FormatErrorToUi(exception));
        }
    }

    @Override
    public void goToDetailsActivity(MainActivity mainActivity, Issue issue) {

        Intent intent = new Intent(mainActivity, IssueDetailActivity.class);
        intent.putExtra(ISSUE, issue);
        mainActivity.startActivity(intent);

    }

}
