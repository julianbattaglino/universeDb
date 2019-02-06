package com.example.julian.universedb._planetas.mvvm.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.julian.universedb.R;
import com.example.julian.universedb._planetas.activity.PlanetasActivity;
import com.example.julian.universedb._planetas.adapter.PlanetasAdapter;
import com.example.julian.universedb._planetas.mvvm.viewmodel.PlanetasViewModel;
import com.example.julian.universedb.base.mvvm.view.BaseView;
import com.example.julian.universedb.db.entities.Planetas;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Santiago Battaglino.
 */
public class PlanetasView extends BaseView<PlanetasActivity, PlanetasViewModel>
        implements PlanetasAdapter.OnViewHolderClick, MaterialSearchView.OnQueryTextListener {

    @BindView(R.id.search_view)
    public MaterialSearchView mSearchView;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private PlanetasAdapter mAdapter;

    private List<Planetas> mPlanetas = new ArrayList<>();

    @Inject
    public PlanetasView(PlanetasActivity activity, PlanetasViewModel viewModel) {
        super(activity, viewModel);
        ButterKnife.bind(this, activity);

        setUpSearchView();
        setUpList();
    }

    @Override
    protected void subscribeUiToLiveData() {
        subscribePlanetas();
    }

    @Override
    protected void showDataInUi() {

    }


    private void subscribePlanetas() {
        baseViewModel.getPlanetas().observe(baseActivity.get(), planetas -> {
            if (planetas == null || planetas.size() <= 0) {
                baseViewModel.requestDataToServer();
            } else {
                mPlanetas = planetas;
                mAdapter.addAll(mPlanetas);
            }
        });
    }

    private void setUpList() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(baseActivity.get(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new PlanetasAdapter(baseActivity.get(), this, mPlanetas);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void setUpSearchView() {
        mSearchView.setEllipsize(true);
        mSearchView.setOnQueryTextListener(this);
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
    public void onClick(View view, int position, Planetas item) {

    }
}
