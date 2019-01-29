package com.example.julian.universedb.user.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.julian.universedb.base.repository.UseCaseRepository;
import com.example.julian.universedb.db.AppDatabase;
import com.example.julian.universedb.db.entities.Result;
import com.example.julian.universedb.db.entities.User;
import com.example.julian.universedb.global.Constants;
import com.example.julian.universedb.global.services.RandomUserApiServic;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Santiago Battaglino.
 */
public class UserRepository extends UseCaseRepository<User> {

    private AppDatabase mDataBase;
    private RandomUserApiServic mClient;
    private CompositeDisposable mDisposable;

    @Inject
    UserRepository(Application context, RandomUserApiServic client) {
        super(context);
        this.context = context;
        mClient = client;
        mDisposable = new CompositeDisposable();
    }

    public void initLocalData() {
        mDataBase = AppDatabase.getDatabaseBuilder(context);
        setDataList(mDataBase.userModel().loadList());
    }

    @Override
    public void addData(User user) {

    }

    @Override
    public void addDataList(List<User> users) {
        mDataBase.userModel().insertAll(users);
        setDataList(mDataBase.userModel().loadList());
    }

    @Override
    public void requestDataToServer() {

    }

    public void fetchUsersFromServer(int page) {
        mClient.getUsers(Constants.PAGE_RESULTS, page)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Result<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //mDisposable.add(d);
                    }

                    @Override
                    public void onNext(Result<User> dataListFromServer) {
                        addDataList(dataListFromServer.results);
                        //mDisposable.dispose();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void addFavorite(User user) {
        mDataBase.userModel().updateUser(user);
        setDataList(mDataBase.userModel().loadList());
    }

    public LiveData<List<User>> getFavorites() {
        return mDataBase.userModel().loadListFavorites();
    }

    public LiveData<User> getUserBySuggestion(String query) {
        return mDataBase.userModel().loadUserBySuggestion("%" + query + "%");
    }
}
