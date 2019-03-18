package com.leme.gitissuesapp.di;

import com.leme.gitissuesapp.contract.MainContract;
import dagger.Component;


@Component(modules = AppModule.class) //modules accessible by this component
public interface AppComponent {
    void inject(MainContract.View view); //who can use these modules
}
