package com.leme.gitissuesapp.presenter;

import android.content.Intent;
import android.net.Uri;

import com.leme.gitissuesapp.contract.IssueDetailContract;
import com.leme.gitissuesapp.model.Issue;
import com.leme.gitissuesapp.util.IssueUtil;
import com.leme.gitissuesapp.view.activity.IssueDetailActivity;

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
            issue = intent.getExtras().getParcelable(MainPresenter.ISSUE);

            view.setIssueDetailData(issue);

            configureDetailsLayoutByIssueState(issue.getState());
        }

    }

    @Override
    public void goToUrlUser(IssueDetailActivity issueDetailActivity) {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(issue.getUrl()));
        issueDetailActivity.startActivity(intent);

    }

    private void configureDetailsLayoutByIssueState(String state) {

        int iconResource = IssueUtil.getResourceByIconState(state);
        int detailColorStateResource = IssueUtil.getResourceByDetailStateColor(state);
        int bannerResource = IssueUtil.getResourceByBannerState(state);
        int buttonResourceColor = IssueUtil.getResourceColorByButtonState(state);
        int buttonResourceColorFont = IssueUtil.getResourceColorFontByButtonState(state);

        view.setCurrentIconByState(iconResource);
        view.setCurrentDetailColorByState(detailColorStateResource);
        view.setCurrentBannerByState(bannerResource);
        view.setCurrentButtonByState(buttonResourceColor, buttonResourceColorFont);

    }

}
