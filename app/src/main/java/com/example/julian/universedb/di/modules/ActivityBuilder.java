package com.example.julian.universedb.di.modules;


import com.example.julian.universedb._nebulosas.activity.NebulosasActivity;
import com.example.julian.universedb._planetarias.activity.PlanetariasActivity;
import com.example.julian.universedb._planetas.activity.PlanetasActivity;
import com.example.julian.universedb._satelites.activity.SatelitesActivity;
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


    @ContributesAndroidInjector(modules = {UserGridActivityModule.class})
    abstract UserGridActivity bindUserGridActivity();

    @ContributesAndroidInjector(modules = {UserDetailActivityModule.class})
    abstract UserDetailActivity bindUserDetailActivity();

    @ContributesAndroidInjector(modules = {NebulosasActivityModule.class})
    abstract NebulosasActivity bindNebulosasActivity();

    @ContributesAndroidInjector(modules = {PlanetariasActivityModule.class})
    abstract PlanetariasActivity bindPlanetariasActivity();

    @ContributesAndroidInjector(modules = {PlanetasActivityModule.class})
    abstract PlanetasActivity bindPlanetasActivity();

    @ContributesAndroidInjector(modules = {SatelitesActivityModule.class})
    abstract SatelitesActivity bindSatelitesActivity();
}
