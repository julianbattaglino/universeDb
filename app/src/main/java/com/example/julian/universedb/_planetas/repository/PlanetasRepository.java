package com.example.julian.universedb._planetas.repository;

import android.app.Application;

import com.example.julian.universedb.base.repository.UseCaseRepository;
import com.example.julian.universedb.db.AppDatabase;
import com.example.julian.universedb.db.entities.Planetas;
import com.example.julian.universedb.global.models.PlanetasApiResponse;
import com.example.julian.universedb.global.services.PlanetasApiService;

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
public class PlanetasRepository extends UseCaseRepository<Planetas> {

    private AppDatabase mDataBase;
    private PlanetasApiService mClient;
    private CompositeDisposable mDisposable;

    @Inject
    PlanetasRepository(Application context, PlanetasApiService client) {
        super(context);
        this.context = context;
        mClient = client;
        mDisposable = new CompositeDisposable();
    }

    public void initLocalData() {
        mDataBase = AppDatabase.getDatabaseBuilder(context);
        setDataList(mDataBase.planetasModel().loadList());
    }

    @Override
    public void addData(Planetas planetas) {

    }

    @Override
    public void addDataList(List<Planetas> planetas) {
        mDataBase.planetasModel().insertList(planetas);
        setDataList(mDataBase.planetasModel().loadList());
    }

    @Override
    public void requestDataToServer() {
        mClient.getPlanetas()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PlanetasApiResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable.add(d);
                    }

                    @Override
                    public void onNext(PlanetasApiResponse planetasApiResponse) {
                        addDataList(planetasApiResponse.planetas);
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
