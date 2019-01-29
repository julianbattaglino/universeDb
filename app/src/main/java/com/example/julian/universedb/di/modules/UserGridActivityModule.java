package com.example.julian.universedb.di.modules;


import com.example.julian.universedb.user.activity.UserGridActivity;
import com.example.julian.universedb.user.mvvm.view.UserGridView;
import com.example.julian.universedb.user.mvvm.viewmodel.UserGridViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Santiago Battaglino.
 */
@Module
public class UserGridActivityModule {

    @Provides
    UserGridView provideUserGridView(UserGridActivity activity, UserGridViewModel viewModel) {
        return new UserGridView(activity, viewModel);
    }
}
