package com.example.julian.universedb.di.modules;

import android.app.Application;

import com.example.julian.universedb.global.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Santiago Battaglino.
 */
@Module(includes = {RetrofitModule.class})
public class AppModule {

    @Provides
    @Singleton
    Application provideContext(App application) {
        return application;
    }
}
