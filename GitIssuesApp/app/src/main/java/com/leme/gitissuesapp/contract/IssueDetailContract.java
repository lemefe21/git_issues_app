package com.leme.gitissuesapp.contract;

import android.content.Intent;
import com.leme.gitissuesapp.model.Issue;
import com.leme.gitissuesapp.view.activity.IssueDetailActivity;

public interface IssueDetailContract {

    interface View {
        void setIssueDetailData(Issue issue);
        void setCurrentIconByState(int resource);
        void setCurrentDetailColorByState(int resource);
        void setCurrentBannerByState(int resource);
        void setCurrentButtonByState(int resourceColor, int resourceFontColor);
        void openUrlUser(android.view.View view);
    }

    interface Presenter {

        void onDestroy();
        void getIntentExtras(Intent intent);
        void goToUrlUser(IssueDetailActivity issueDetailActivity);

    }

}
