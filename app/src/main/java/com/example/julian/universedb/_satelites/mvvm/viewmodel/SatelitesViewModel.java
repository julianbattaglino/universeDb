package com.example.julian.universedb._satelites.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.julian.universedb._satelites.repository.SatelitesRepository;
import com.example.julian.universedb.base.mvvm.viewmodel.BaseViewModel;
import com.example.julian.universedb.db.entities.Satelites;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Santiago Battaglino.
 */
public class SatelitesViewModel extends BaseViewModel<Satelites, SatelitesRepository> {

    @Inject
    SatelitesViewModel(Application application, SatelitesRepository repository) {
        super(application);
        this.useCaseRepository = repository;
    }


    public void requestDataToServer() {
        useCaseRepository.requestDataToServer();
    }

    public LiveData<List<Satelites>> getSatelites() {
        return useCaseRepository.getDataList();
    }
}
