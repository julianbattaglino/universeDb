package com.example.julian.universedb._nebulosas.mvvm.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.julian.universedb.R;
import com.example.julian.universedb._nebulosas.activity.NebulosasActivity;
import com.example.julian.universedb._nebulosas.adapter.NebulosasAdapter;
import com.example.julian.universedb._nebulosas.mvvm.viewmodel.NebulosasViewModel;
import com.example.julian.universedb.base.mvvm.view.BaseView;
import com.example.julian.universedb.db.entities.Nebulosas;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Santiago Battaglino.
 */
public class NebulosasView extends BaseView<NebulosasActivity, NebulosasViewModel>
        implements NebulosasAdapter.OnViewHolderClick, MaterialSearchView.OnQueryTextListener {

    @BindView(R.id.search_view)
    public MaterialSearchView mSearchView;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private NebulosasAdapter mAdapter;

    private List<Nebulosas> mNebulosas = new ArrayList<>();

    public NebulosasView(NebulosasActivity activity, NebulosasViewModel viewModel) {
        super(activity, viewModel);
        ButterKnife.bind(this, activity);

        setUpSearchView();
        setUpList();
    }

    @Override
    protected void subscribeUiToLiveData() {
        subscribeNebulosas();
    }

    @Override
    protected void showDataInUi() {

    }


    private void subscribeNebulosas() {
        baseViewModel.getNebulosas().observe(baseActivity.get(), nebulosas -> {
            if (nebulosas == null || nebulosas.size() <= 0) {
                baseViewModel.requestDataToServer();
            } else {
                mNebulosas = nebulosas;
                mAdapter.addAll(mNebulosas);
            }
        });
    }

    private void setUpList() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(baseActivity.get(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new NebulosasAdapter(baseActivity.get(), this, mNebulosas);
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
    public void onClick(View view, int position, Nebulosas item) {

    }
}


