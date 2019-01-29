package com.example.julian.universedb.user.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.julian.universedb.base.mvvm.viewmodel.BaseViewModel;
import com.example.julian.universedb.db.entities.User;
import com.example.julian.universedb.user.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Santiago Battaglino.
 */
public class UserGridViewModel extends BaseViewModel<User, UserRepository> {

    @Inject
    UserGridViewModel(Application application, UserRepository repository) {
        super(application);
        this.useCaseRepository = repository;
    }

    public LiveData<List<User>> getUsers() {
        return useCaseRepository.getDataList();
    }

    public LiveData<List<User>> getFavorites() {
        return useCaseRepository.getFavorites();
    }

    public void fetchUsersFromServer(int page) {
        useCaseRepository.fetchUsersFromServer(page);
    }

    public void addFavorite(User user) {
        useCaseRepository.addFavorite(user);
    }

    public LiveData<User> getUserBySuggestion(String query) {
        return useCaseRepository.getUserBySuggestion(query);
    }
}