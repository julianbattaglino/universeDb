package com.example.julian.universedb.di.modules;

import com.example.julian.universedb._satelites.activity.SatelitesActivity;
import com.example.julian.universedb._satelites.mvvm.view.SatelitesView;
import com.example.julian.universedb._satelites.mvvm.viewmodel.SatelitesViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class SatelitesActivityModule {

    @Provides
    SatelitesView provideSatelitesView(SatelitesActivity activity, SatelitesViewModel viewModel) {
        return new SatelitesView(activity, viewModel);
    }
}


