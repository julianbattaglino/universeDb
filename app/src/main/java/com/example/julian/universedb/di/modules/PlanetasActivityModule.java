package com.example.julian.universedb.di.modules;

import com.example.julian.universedb._planetarias.activity.PlanetariasActivity;
import com.example.julian.universedb._planetarias.mvvm.view.PlanetariasView;
import com.example.julian.universedb._planetarias.mvvm.viewmodel.PlanetariasViewModel;

import dagger.Module;
import dagger.Provides;

@Module
class PlanetasActivityModule {
    @Provides
    PlanetariasView providePlanetariasView(PlanetariasActivity activity, PlanetariasViewModel viewModel) {
        return new PlanetariasView(activity, viewModel);
    }
}