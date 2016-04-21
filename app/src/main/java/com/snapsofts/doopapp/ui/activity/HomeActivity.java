package com.snapsofts.doopapp.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.snapsofts.doopapp.R;
import com.snapsofts.doopapp.data.model.User;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_coupon);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    @Override
    protected void buttonHomeClick() {
    }

    @OnClick(R.id.btnUserMenu)
    public void onClick() {
        if (!User.userLoggedIn(getApplicationContext())) { //User not logged in => Show login screen.
            gotoLogin();
        } else {
            //TODO - Add this item to wishlist
        }
    }
}
