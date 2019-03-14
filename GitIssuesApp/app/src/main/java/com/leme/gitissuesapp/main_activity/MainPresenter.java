package com.leme.gitissuesapp.main_activity;

import com.leme.gitissuesapp.model.Issues;

import java.util.List;

public class MainPresenter implements MainContract.Presenter, MainContract.Model.OnFinishListener {

    private MainContract.MainView view;
    private MainContract.Model model;

    public MainPresenter(MainContract.MainView view) {
        this.view = view;
        model = new MainModel();
    }

    @Override
    public void onFinished(List<Issues> issuesList) {
        view.setDataToRecyclerView(issuesList);
        if(view != null) {
            view.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable throwable) {

        view.showError(ExceptionHandler.FormatError(throwable));
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
        try{
            if(view != null) {
                view.showProgress();
            }
            model.getIssuesList(this);
        }catch (Exception e){
            this.view.showError(ExceptionHandler.FormatError(e));
        }

    }
}
