package com.leme.gitissuesapp.presenter;

import android.content.Intent;

import com.leme.gitissuesapp.R;
import com.leme.gitissuesapp.contract.IssueDetailContract;
import com.leme.gitissuesapp.model.Issue;

public class IssueDetailPresenter implements IssueDetailContract.Presenter {

    private IssueDetailContract.View view;
    private Issue issue;

    public IssueDetailPresenter(IssueDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }

    @Override
    public void getIntentExtras(Intent intent) {

        if(intent.hasExtra(MainPresenter.ISSUE)) {
            issue = (Issue) intent.getSerializableExtra(MainPresenter.ISSUE);
            view.setIssueDetailData(issue);
            //view.setCurrentIconByState(R.drawable.ic_lock_open_green_48dp);
        }

    }

}
