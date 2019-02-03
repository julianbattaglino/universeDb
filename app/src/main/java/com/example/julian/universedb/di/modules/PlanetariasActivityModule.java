package com.example.julian.universedb.di.modules;

import com.example.julian.universedb.planetarias.activity.PlanetariasActivity;
import com.example.julian.universedb.planetarias.mvvm.view.PlanetariasView;
import com.example.julian.universedb.planetarias.mvvm.viewmodel.PlanetariasViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class PlanetariasActivityModule {
    @Provides
    PlanetariasView providePlanetariasView(PlanetariasActivity activity, PlanetariasViewModel viewModel) {
        return new PlanetariasView(activity, viewModel);
    }
}