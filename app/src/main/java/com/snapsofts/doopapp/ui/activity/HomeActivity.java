package com.snapsofts.doopapp.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.snapsofts.doopapp.R;
import com.snapsofts.doopapp.data.model.User;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_coupon);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!User.userLoggedIn(HomeActivity.this)) { //User not logged in => Show login screen.
                    gotoLogin();
                } else {
                    //TODO - Add this item to wishlist
                }
            }
        });
    }

    @Override
    protected void buttonHomeClick() {
    }
}
