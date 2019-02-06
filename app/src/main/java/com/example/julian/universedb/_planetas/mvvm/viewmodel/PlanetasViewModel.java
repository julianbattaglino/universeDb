package com.example.julian.universedb._planetas.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.julian.universedb._planetas.repository.PlanetasRepository;
import com.example.julian.universedb.base.mvvm.viewmodel.BaseViewModel;
import com.example.julian.universedb.db.entities.Planetas;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Santiago Battaglino.
 */
public class PlanetasViewModel extends BaseViewModel<Planetas, PlanetasRepository> {

    @Inject
    PlanetasViewModel(Application application, PlanetasRepository repository) {
        super(application);
        this.useCaseRepository = repository;
    }


    public void requestDataToServer() {
        useCaseRepository.requestDataToServer();
    }

    public LiveData<List<Planetas>> getPlanetas() {
        return useCaseRepository.getDataList();
    }
}
