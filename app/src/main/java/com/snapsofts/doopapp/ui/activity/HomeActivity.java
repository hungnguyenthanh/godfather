package com.snapsofts.doopapp.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.snapsofts.doopapp.R;
import com.snapsofts.doopapp.data.model.User;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @Bind(R.id.btnWishList)
    TextView btnWishList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    protected void buttonHomeClick() {
    }

    @OnClick(R.id.btnAdd)
    public void onClick() {
        if (!User.userLoggedIn(getApplicationContext())) { //User not logged in => Show login screen.
            gotoLogin();
        } else {
            //TODO - Add this item to wishlist

        }
    }
}
