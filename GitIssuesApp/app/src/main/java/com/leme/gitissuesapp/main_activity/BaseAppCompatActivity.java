package com.leme.gitissuesapp.main_activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaseAppCompatActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.progressBar)
    ProgressBar mLoadingProgress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
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
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
