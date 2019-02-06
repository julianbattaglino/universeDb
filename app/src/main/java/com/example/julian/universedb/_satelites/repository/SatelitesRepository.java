package com.example.julian.universedb._satelites.repository;

import android.app.Application;

import com.example.julian.universedb.base.repository.UseCaseRepository;
import com.example.julian.universedb.db.AppDatabase;
import com.example.julian.universedb.db.entities.Satelites;
import com.example.julian.universedb.global.models.SatelitesApiResponse;
import com.example.julian.universedb.global.services.SatelitesApiService;

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
public class SatelitesRepository extends UseCaseRepository<Satelites> {

    private AppDatabase mDataBase;
    private SatelitesApiService mClient;
    private CompositeDisposable mDisposable;

    @Inject
    SatelitesRepository(Application context, SatelitesApiService client) {
        super(context);
        this.context = context;
        mClient = client;
        mDisposable = new CompositeDisposable();
    }

    public void initLocalData() {
        mDataBase = AppDatabase.getDatabaseBuilder(context);
        setDataList(mDataBase.satelitesModel().loadList());
    }

    @Override
    public void addData(Satelites satelites) {

    }

    @Override
    public void addDataList(List<Satelites> satelites) {
        mDataBase.satelitesModel().insertList(satelites);
        setDataList(mDataBase.satelitesModel().loadList());
    }

    @Override
    public void requestDataToServer() {
        mClient.getSatelites()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SatelitesApiResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable.add(d);
                    }

                    @Override
                    public void onNext(SatelitesApiResponse satelitesApiResponse) {
                        addDataList(satelitesApiResponse.satelites);
                        mDisposable.dispose();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
