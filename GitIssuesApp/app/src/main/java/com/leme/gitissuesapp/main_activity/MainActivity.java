package com.leme.gitissuesapp.main_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.leme.gitissuesapp.R;
import com.leme.gitissuesapp.model.Issues;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseAppCompatActivity implements MainContract.MainView {

    private MainPresenter mPresenter;

    @BindView(R.id.hello)
    TextView mTextView;

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
    public void setDataToRecyclerView(List<Issues> issuesList) {
        mTextView.setText(String.valueOf(issuesList.get(0).getId()));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
