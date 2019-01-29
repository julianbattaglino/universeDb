package com.example.julian.universedb.di.modules;


import com.example.julian.universedb.liga.activity.LigaActivity;
import com.example.julian.universedb.liga.mvvm.view.LigaView;
import com.example.julian.universedb.liga.mvvm.viewmodel.LigaViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Santiago Battaglino.
 */
@Module
public class LigaActivityModule {

    @Provides
    LigaView provideLigaView(LigaActivity activity, LigaViewModel viewModel) {
        return new LigaView(activity, viewModel);
    }
}
