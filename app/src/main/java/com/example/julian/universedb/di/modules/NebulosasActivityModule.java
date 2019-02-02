package com.example.julian.universedb.di.modules;


import com.example.julian.universedb.nebulosas.activity.NebulosasActivity;
import com.example.julian.universedb.nebulosas.mvvm.view.NebulosasView;
import com.example.julian.universedb.nebulosas.mvvm.viewmodel.NebulosasViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class NebulosasActivityModule {

    @Provides
    NebulosasView provideNebulosasView(NebulosasActivity activity, NebulosasViewModel viewModel) {
        return new NebulosasView(activity, viewModel);
    }
}