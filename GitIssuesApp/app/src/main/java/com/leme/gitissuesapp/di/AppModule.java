package com.leme.gitissuesapp.di;

import com.leme.gitissuesapp.contract.MainContract;
import com.leme.gitissuesapp.presenter.MainPresenter;

import dagger.Provides;
import dagger.Module;

@Module
public class AppModule {

    private final MainContract.View activity;

    public AppModule(MainContract.View activity) {
        this.activity = activity;
    }

    @Provides
    public MainContract.View provideView() {
        return activity;
    }

    @Provides
    public MainPresenter provideMainPresenter() {
        return new MainPresenter(activity);
    }

}
