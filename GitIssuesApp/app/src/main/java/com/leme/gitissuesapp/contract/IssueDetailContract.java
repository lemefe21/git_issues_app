package com.leme.gitissuesapp.contract;

import android.content.Intent;

import com.leme.gitissuesapp.model.Issue;

public interface IssueDetailContract {

    interface View {
        void setIssueDetailData(Issue issue);
        void setCurrentIconByState(int resource);
    }

    interface Presenter {

        void onDestroy();
        void getIntentExtras(Intent intent);

    }

}
