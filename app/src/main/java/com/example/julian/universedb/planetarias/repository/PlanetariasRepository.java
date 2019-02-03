package com.example.julian.universedb.planetarias.repository;

import android.app.Application;

import com.example.julian.universedb.base.repository.UseCaseRepository;
import com.example.julian.universedb.db.AppDatabase;
import com.example.julian.universedb.db.entities.Planetarias;
import com.example.julian.universedb.global.models.PlanetariasApiResponse;
import com.example.julian.universedb.global.services.PlanetariasApiService;

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
public class PlanetariasRepository extends UseCaseRepository<Planetarias> {

    private AppDatabase mDataBase;
    private PlanetariasApiService mClient;
    private CompositeDisposable mDisposable;

    @Inject
    PlanetariasRepository(Application context, PlanetariasApiService client) {
        super(context);
        this.context = context;
        mClient = client;
        mDisposable = new CompositeDisposable();
    }

    public void initLocalData() {
        mDataBase = AppDatabase.getDatabaseBuilder(context);
        setDataList(mDataBase.planetariasModel().loadList());
    }

    @Override
    public void addData(Planetarias planetarias) {

    }

    @Override
    public void addDataList(List<Planetarias> planetarias) {
        mDataBase.planetariasModel().insertList(planetarias);
        setDataList(mDataBase.planetariasModel().loadList());
    }

    @Override
    public void requestDataToServer() {
        mClient.getPlanetarias()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PlanetariasApiResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable.add(d);
                    }

                    @Override
                    public void onNext(PlanetariasApiResponse planetariasapiResponse) {
                        addDataList(planetariasapiResponse.planetarias);
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

