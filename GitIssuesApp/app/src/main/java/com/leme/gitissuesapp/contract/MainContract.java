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

    interface View {

        void showProgress();
        void hideProgress();
        void setDataToRecyclerView(List<Issues> issuesList);
        void onResponseFailure(Throwable throwable);

    }

    interface Presenter {

        void onDestroy();
        void requestDataFromServer();

    }

}
