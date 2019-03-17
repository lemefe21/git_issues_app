package com.leme.gitissuesapp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.leme.gitissuesapp.R;
import com.leme.gitissuesapp.adapter.IssueItemAdapter;
import com.leme.gitissuesapp.contract.MainContract;
import com.leme.gitissuesapp.di.AppComponent;
import com.leme.gitissuesapp.di.AppModule;
import com.leme.gitissuesapp.di.DaggerAppComponent;
import com.leme.gitissuesapp.presenter.MainPresenter;
import com.leme.gitissuesapp.model.Issue;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View, IssueItemAdapter.IssueItemAdapterOnClickHandle {

    private AppComponent mAppComponent;

    //@Inject
    MainPresenter mPresenter;

   /*public MainActivity() {
        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
        mAppComponent.inject(this);
    }*/

    private IssueItemAdapter mIssueItemAdapter;

    @BindView(R.id.activity_main_rv_issues_list)
    RecyclerView mRecylerViewIssuesItem;

    @BindView(R.id.activity_main_pb_issues_list)
    ProgressBar mLoadingProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();

    }

    private void initUi() {

        ButterKnife.bind(this);

        mPresenter = new MainPresenter(this);
        mPresenter.requestDataFromServer();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecylerViewIssuesItem.setLayoutManager(layoutManager);
        mIssueItemAdapter = new IssueItemAdapter(this, this);
        mRecylerViewIssuesItem.setAdapter(mIssueItemAdapter);

    }

    @Override
    public void showProgress() {
        mRecylerViewIssuesItem.setVisibility(View.GONE);
        mLoadingProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mLoadingProgress.setVisibility(View.GONE);
        mRecylerViewIssuesItem.setVisibility(View.VISIBLE);
    }

    @Override
    public void setDataToRecyclerView(List<Issue> issuesList) {
        mIssueItemAdapter.setIssuesData(issuesList);
    }

    @Override
    public void showError(int error) {
        Toast.makeText(this, getString(error), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void onClick(Issue issueClicked) {
        Toast.makeText(this, "Issue user login: " + issueClicked.getUser().getLogin(), Toast.LENGTH_SHORT).show();
        mPresenter.goToDetailsActivity(this, issueClicked);
    }
}
