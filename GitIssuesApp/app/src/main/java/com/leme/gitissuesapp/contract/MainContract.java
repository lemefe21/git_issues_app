package com.leme.gitissuesapp.contract;

import com.leme.gitissuesapp.model.Issue;
import com.leme.gitissuesapp.view.activity.MainActivity;

import java.util.List;

public interface MainContract {

    interface Service {

        interface RequestListener {
            void success(List<Issue> issuesList);
            void error(Throwable throwable);
        }

        void getIssues(RequestListener requestListener);

    }

    interface View {

        void showProgress();
        void hideProgress();
        void setDataToRecyclerView(List<Issue> issuesList);
        void showError(int error);

    }

    interface Presenter {

        void onDestroy();
        void requestDataFromServer();
        void goToDetailsActivity(MainActivity mainActivity, Issue issue);

    }

}
