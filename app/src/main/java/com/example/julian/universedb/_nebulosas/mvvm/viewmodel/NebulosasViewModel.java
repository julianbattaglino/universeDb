package com.example.julian.universedb._nebulosas.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.julian.universedb._nebulosas.repository.NebulosasRepository;
import com.example.julian.universedb.base.mvvm.viewmodel.BaseViewModel;
import com.example.julian.universedb.db.entities.Nebulosas;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Santiago Battaglino.
 */
public class NebulosasViewModel extends BaseViewModel<Nebulosas, NebulosasRepository> {

    @Inject
    NebulosasViewModel(Application application, NebulosasRepository repository) {
        super(application);
        this.useCaseRepository = repository;
    }


    public void requestDataToServer() {
        useCaseRepository.requestDataToServer();
    }

    public LiveData<List<Nebulosas>> getNebulosas() {
        return useCaseRepository.getDataList();
    }
}
