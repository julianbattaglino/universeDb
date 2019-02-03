package com.example.julian.universedb.planetarias.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.julian.universedb.R;
import com.example.julian.universedb.base.activity.BaseActivity;
import com.example.julian.universedb.planetarias.mvvm.view.PlanetariasView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by Santiago Battaglino.
 */
public class PlanetariasActivity extends BaseActivity {

    @Inject
    PlanetariasView view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_planetarias);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void injectThis() {
        AndroidInjection.inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            view.mSearchView.showSearch(true);
            view.mSearchView.setVisibility(View.VISIBLE);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (view.mSearchView.isSearchOpen()) {
            view.mSearchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }
}
