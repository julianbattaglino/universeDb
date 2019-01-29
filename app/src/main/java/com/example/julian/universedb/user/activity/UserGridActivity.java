package com.example.julian.universedb.user.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.julian.universedb.R;
import com.example.julian.universedb.base.activity.BaseActivity;
import com.example.julian.universedb.user.mvvm.view.UserGridView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class UserGridActivity extends BaseActivity {

    @Inject
    UserGridView view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_user_grid);
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
