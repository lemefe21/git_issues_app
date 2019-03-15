package com.leme.gitissuesapp.contract;

import com.leme.gitissuesapp.model.Issues;

import java.util.List;

public interface MainContract {

    interface Service {

        interface RequestListener {
            void success(List<Issues> issuesList);
            void error(Throwable throwable);
        }

        void getIssues(RequestListener requestListener);

    }

    interface MainView {
        void showProgress();
        void hideProgress();
        void showError(int error);
        void setDataToRecyclerView(List<Issues> issuesList);
    }

    interface Presenter {

        void onDestroy();
        void requestDataFromServer();

    }

}
