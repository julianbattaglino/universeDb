package com.example.julian.universedb.di.modules;


import com.example.julian.universedb.liga.activity.LigaActivity;
import com.example.julian.universedb.mydb.activity.MyDbActivity;
import com.example.julian.universedb.nebulosas.activity.NebulosasActivity;
import com.example.julian.universedb.planetarias.activity.PlanetariasActivity;
import com.example.julian.universedb.user.activity.UserDetailActivity;
import com.example.julian.universedb.user.activity.UserGridActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Santiago Battaglino.
 * <p>
 * This is a given module to dagger. We map all our activities here.
 * And Dagger know our activities in compile time.
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {LigaActivityModule.class})
    abstract LigaActivity bindLigaActivity();

    @ContributesAndroidInjector(modules = {MyDbActivityModule.class})
    abstract MyDbActivity bindDbActivity();

    @ContributesAndroidInjector(modules = {UserGridActivityModule.class})
    abstract UserGridActivity bindUserGridActivity();

    @ContributesAndroidInjector(modules = {UserDetailActivityModule.class})
    abstract UserDetailActivity bindUserDetailActivity();

    @ContributesAndroidInjector(modules = {NebulosasActivityModule.class})
    abstract NebulosasActivity bindNebulosasActivity();

    @ContributesAndroidInjector(modules = {PlanetariasActivityModule.class})
    abstract PlanetariasActivity bindPlanetariasActivity();

}
