package com.example.julian.universedb.planetarias.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.julian.universedb.base.mvvm.viewmodel.BaseViewModel;
import com.example.julian.universedb.db.entities.Planetarias;
import com.example.julian.universedb.planetarias.repository.PlanetariasRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Santiago Battaglino.
 */
public class PlanetariasViewModel extends BaseViewModel<Planetarias, PlanetariasRepository> {

    @Inject
    PlanetariasViewModel(Application application, PlanetariasRepository repository) {
        super(application);
        this.useCaseRepository = repository;
    }


    public void requestDataToServer() {
        useCaseRepository.requestDataToServer();
    }

    public LiveData<List<Planetarias>> getPlanetarias() {
        return useCaseRepository.getDataList();
    }
}
