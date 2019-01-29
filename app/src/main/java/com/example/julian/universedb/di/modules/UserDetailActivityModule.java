package com.example.julian.universedb.di.modules;


import com.example.julian.universedb.user.activity.UserDetailActivity;
import com.example.julian.universedb.user.mvvm.view.UserDetailView;
import com.example.julian.universedb.user.mvvm.viewmodel.UserGridViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Santiago Battaglino.
 */
@Module
public class UserDetailActivityModule {

    @Provides
    UserDetailView provideUserDetailView(UserDetailActivity activity, UserGridViewModel viewModel) {
        return new UserDetailView(activity, viewModel);
    }
}
