package com.example.julian.universedb.nebulosas.repository;

import android.app.Application;

import com.example.julian.universedb.base.repository.UseCaseRepository;
import com.example.julian.universedb.db.AppDatabase;
import com.example.julian.universedb.db.entities.Nebulosas;
import com.example.julian.universedb.global.models.NebulasApiResponse;
import com.example.julian.universedb.global.services.NebulasApiServices;

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
public class NebulosasRepository extends UseCaseRepository<Nebulosas> {

    private AppDatabase mDataBase;
    private NebulasApiServices mClient;
    private CompositeDisposable mDisposable;

    @Inject
    NebulosasRepository(Application context, NebulasApiServices client) {
        super(context);
        this.context = context;
        mClient = client;
        mDisposable = new CompositeDisposable();
    }

    public void initLocalData() {
        mDataBase = AppDatabase.getDatabaseBuilder(context);
        setDataList(mDataBase.nebulosasModel().loadList());
    }

    @Override
    public void addData(Nebulosas nebulosa) {

    }

    @Override
    public void addDataList(List<Nebulosas> nebulosas) {
        mDataBase.nebulosasModel().insertList(nebulosas);
        setDataList(mDataBase.nebulosasModel().loadList());
    }

    @Override
    public void requestDataToServer() {
        mClient.getNebulas()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NebulasApiResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable.add(d);
                    }

                    @Override
                    public void onNext(NebulasApiResponse apiResponse) {
                        addDataList(apiResponse.Nebulosas);
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

