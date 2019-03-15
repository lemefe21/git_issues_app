package com.leme.gitissuesapp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.leme.gitissuesapp.R;
import com.leme.gitissuesapp.contract.MainContract;
import com.leme.gitissuesapp.presenter.MainPresenter;
import com.leme.gitissuesapp.model.Issues;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainPresenter mPresenter;

    @BindView(R.id.hello)
    TextView mTextView;

    @BindView(R.id.progressBar)
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

    }

    @Override
    public void showProgress() {
        mLoadingProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mLoadingProgress.setVisibility(View.GONE);
    }

    @Override
    public void setDataToRecyclerView(List<Issues> issuesList) {
        mTextView.setText(String.valueOf(issuesList.get(0).getId()));
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
}
