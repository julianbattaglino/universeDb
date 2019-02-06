package com.example.julian.universedb._satelites.mvvm.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.julian.universedb.R;
import com.example.julian.universedb._satelites.activity.SatelitesActivity;
import com.example.julian.universedb._satelites.adapter.SatelitesAdapter;
import com.example.julian.universedb._satelites.mvvm.viewmodel.SatelitesViewModel;
import com.example.julian.universedb.base.mvvm.view.BaseView;
import com.example.julian.universedb.db.entities.Satelites;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Santiago Battaglino.
 */
public class SatelitesView extends BaseView<SatelitesActivity, SatelitesViewModel>
        implements SatelitesAdapter.OnViewHolderClick, MaterialSearchView.OnQueryTextListener {

    @BindView(R.id.search_view)
    public MaterialSearchView mSearchView;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private SatelitesAdapter mAdapter;

    private List<Satelites> mSatelites = new ArrayList<>();

    @Inject
    public SatelitesView(SatelitesActivity activity, SatelitesViewModel viewModel) {
        super(activity, viewModel);
        ButterKnife.bind(this, activity);

        setUpSearchView();
        setUpList();
    }

    @Override
    protected void subscribeUiToLiveData() {
        subscribeSatelites();
    }

    @Override
    protected void showDataInUi() {

    }


    private void subscribeSatelites() {
        baseViewModel.getSatelites().observe(baseActivity.get(), satelites -> {
            if (satelites == null || satelites.size() <= 0) {
                baseViewModel.requestDataToServer();
            } else {
                mSatelites = satelites;
                mAdapter.addAll(mSatelites);
            }
        });
    }

    private void setUpList() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(baseActivity.get(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new SatelitesAdapter(baseActivity.get(), this, mSatelites);
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
    public void onClick(View view, int position, Satelites item) {

    }
}
