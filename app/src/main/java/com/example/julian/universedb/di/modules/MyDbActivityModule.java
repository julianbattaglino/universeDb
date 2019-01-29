package com.example.julian.universedb.di.modules;


import com.example.julian.universedb.mydb.activity.MyDbActivity;
import com.example.julian.universedb.mydb.mvvm.view.DbView;
import com.example.julian.universedb.mydb.mvvm.viewmodel.DbViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class MyDbActivityModule {

    @Provides
    DbView provideDbView(MyDbActivity activity, DbViewModel viewModel) {
        return new DbView(activity, viewModel);
    }
}


