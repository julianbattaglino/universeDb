package com.example.julian.universedb.user.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

import com.example.julian.universedb.R;
import com.example.julian.universedb.base.activity.BaseActivity;
import com.example.julian.universedb.db.entities.User;
import com.example.julian.universedb.global.Constants;
import com.example.julian.universedb.user.mvvm.view.UserDetailView;

import org.parceler.Parcels;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class UserDetailActivity extends BaseActivity {

    @Inject
    UserDetailView view;

    private User user;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_user_detail);
        user = Parcels.unwrap(getIntent().getParcelableExtra(Constants.ARG_USER));
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void injectThis() {
        AndroidInjection.inject(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpTo(this, new Intent(this, UserGridActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public User getUser() {
        return user;
    }
}
