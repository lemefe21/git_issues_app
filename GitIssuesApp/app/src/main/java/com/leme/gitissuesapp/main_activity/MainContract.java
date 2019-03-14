package com.leme.gitissuesapp.main_activity;

import com.leme.gitissuesapp.model.Issues;

import java.util.List;

public interface MainContract {

    interface Model {

        interface OnFinishListener {
            void onFinished(List<Issues> issuesList);
            void onFailure(Throwable t);
        }

        void getIssuesList(OnFinishListener onFinishListener);

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
