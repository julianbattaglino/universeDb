package com.example.julian.universedb.liga.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.julian.universedb.base.mvvm.viewmodel.BaseViewModel;
import com.example.julian.universedb.db.entities.Liga;
import com.example.julian.universedb.liga.repository.LigaRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Santiago Battaglino.
 */
public class LigaViewModel extends BaseViewModel<Liga, LigaRepository> {

    @Inject
    LigaViewModel(Application application, LigaRepository repository) {
        super(application);
        this.useCaseRepository = repository;
    }

    public LiveData<List<Liga>> getLigas() {
        return useCaseRepository.getDataList();
    }

    public void requestDataToServer() {
        useCaseRepository.requestDataToServer();
    }
}
