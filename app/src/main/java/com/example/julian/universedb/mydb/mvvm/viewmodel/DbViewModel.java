package com.example.julian.universedb.mydb.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.julian.universedb.base.mvvm.viewmodel.BaseViewModel;
import com.example.julian.universedb.db.entities.Users;
import com.example.julian.universedb.mydb.repository.UsersRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Santiago Battaglino.
 */
public class DbViewModel extends BaseViewModel<Users, UsersRepository> {

    @Inject
    DbViewModel(Application application, UsersRepository repository) {
        super(application);
        this.useCaseRepository = repository;
    }


    public void requestDataToServer() {
        useCaseRepository.requestDataToServer();
    }

    public LiveData<List<Users>> getUsers() {
        return useCaseRepository.getDataList();
    }
}
