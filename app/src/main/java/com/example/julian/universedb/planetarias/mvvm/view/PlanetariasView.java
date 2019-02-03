package com.example.julian.universedb.planetarias.mvvm.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.julian.universedb.R;
import com.example.julian.universedb.base.mvvm.view.BaseView;
import com.example.julian.universedb.db.entities.Planetarias;
import com.example.julian.universedb.planetarias.activity.PlanetariasActivity;
import com.example.julian.universedb.planetarias.adapter.PlanetariasAdapter;
import com.example.julian.universedb.planetarias.mvvm.viewmodel.PlanetariasViewModel;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Santiago Battaglino.
 */
public class PlanetariasView extends BaseView<PlanetariasActivity, PlanetariasViewModel>
        implements PlanetariasAdapter.OnViewHolderClick, MaterialSearchView.OnQueryTextListener {

    @BindView(R.id.search_view)
    public MaterialSearchView mSearchView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private PlanetariasAdapter mAdapter;

    private List<Planetarias> mPlanetarias = new ArrayList<>();

    public PlanetariasView(PlanetariasActivity activity, PlanetariasViewModel viewModel) {
        super(activity, viewModel);
        ButterKnife.bind(this, activity);

        setUpNavigation(toolbar);
        setUpSearchView();
        setUpList();
    }

    @Override
    protected void subscribeUiToLiveData() {
        subscribePlanetarias();
    }

    @Override
    protected void showDataInUi() {

    }


    private void subscribePlanetarias() {
        baseViewModel.getPlanetarias().observe(baseActivity.get(), planetarias -> {
            if (planetarias == null || planetarias.size() <= 0) {
                baseViewModel.requestDataToServer();
            } else {
                mPlanetarias = planetarias;
                mAdapter.addAll(mPlanetarias);
            }
        });
    }

    private void setUpList() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(baseActivity.get(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new PlanetariasAdapter(baseActivity.get(), this, mPlanetarias);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setUpSearchView() {
        mSearchView.setEllipsize(true);
        mSearchView.setOnQueryTextListener(this);
    }

    private void setUpNavigation(Toolbar toolbar) {
        baseActivity.get().setSupportActionBar(toolbar);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }


    @Override
    public void onClick(View view, int position, Planetarias item) {

    }
}
