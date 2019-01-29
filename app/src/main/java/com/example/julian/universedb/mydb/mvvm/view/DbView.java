package com.example.julian.universedb.mydb.mvvm.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.julian.universedb.R;
import com.example.julian.universedb.base.mvvm.view.BaseView;
import com.example.julian.universedb.db.entities.Users;
import com.example.julian.universedb.mydb.activity.MyDbActivity;
import com.example.julian.universedb.mydb.adapter.MyDbAdapter;
import com.example.julian.universedb.mydb.mvvm.viewmodel.DbViewModel;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Santiago Battaglino.
 */
public class DbView extends BaseView<MyDbActivity, DbViewModel>
        implements MyDbAdapter.OnViewHolderClick, MaterialSearchView.OnQueryTextListener {

    @BindView(R.id.search_view)
    public MaterialSearchView mSearchView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private MyDbAdapter mAdapter;

    private List<Users> mUsers = new ArrayList<>();

    public DbView(MyDbActivity activity, DbViewModel viewModel) {
        super(activity, viewModel);
        ButterKnife.bind(this, activity);

        setUpNavigation(toolbar);
        setUpSearchView();
        setUpList();
    }

    @Override
    protected void subscribeUiToLiveData() {
        subscribeUsers();
    }

    @Override
    protected void showDataInUi() {

    }


    private void subscribeUsers() {
        baseViewModel.getUsers().observe(baseActivity.get(), users -> {
            if (users == null || users.size() <= 0) {
                baseViewModel.requestDataToServer();
            } else {
                mUsers = users;
                mAdapter.addAll(mUsers);
            }
        });
    }

    private void setUpList() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(baseActivity.get(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyDbAdapter(baseActivity.get(), this, mUsers);
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
    public void onClick(View view, int position, Users item) {

    }
}
