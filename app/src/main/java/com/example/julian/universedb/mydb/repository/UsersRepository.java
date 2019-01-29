package com.example.julian.universedb.mydb.repository;

import android.app.Application;

import com.example.julian.universedb.base.repository.UseCaseRepository;
import com.example.julian.universedb.db.AppDatabase;
import com.example.julian.universedb.db.entities.Users;
import com.example.julian.universedb.global.models.ApiResponse;
import com.example.julian.universedb.global.services.MyApiServices;

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
public class UsersRepository extends UseCaseRepository<Users> {

    private AppDatabase mDataBase;
    private MyApiServices mClient;
    private CompositeDisposable mDisposable;

    @Inject
    UsersRepository(Application context, MyApiServices client) {
        super(context);
        this.context = context;
        mClient = client;
        mDisposable = new CompositeDisposable();
    }

    public void initLocalData() {
        mDataBase = AppDatabase.getDatabaseBuilder(context);
        setDataList(mDataBase.usersModel().loadList());
    }

    @Override
    public void addData(Users user) {

    }

    @Override
    public void addDataList(List<Users> users) {
        mDataBase.usersModel().insertList(users);
        setDataList(mDataBase.usersModel().loadList());
    }

    @Override
    public void requestDataToServer() {
        mClient.getApiResponse()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApiResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable.add(d);
                    }

                    @Override
                    public void onNext(ApiResponse apiResponse) {
                        addDataList(apiResponse.users);
                        mDisposable.dispose();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}

