package com.snapsofts.doopapp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.snapsofts.doopapp.Defines.Constants;
import com.snapsofts.doopapp.R;
import com.snapsofts.doopapp.data.model.User;

/**
 * Created by dangnv on 4/21/16.
 */
public class BaseActivity extends AppCompatActivity {
    protected View btnHome;
    protected View btnWishList;
    protected View btnDashboard;

    protected SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        setupToolbarAction();
    }

    protected void setupToolbarAction() {
        btnHome = findViewById(R.id.btnLogo);
        btnWishList = findViewById(R.id.btnWishList);
        btnDashboard = findViewById(R.id.btnDashboard);

        if (btnHome != null) {
            btnHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(BaseActivity.this, HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            });
        }
        if (btnWishList != null) {
            btnWishList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (User.userLoggedIn(BaseActivity.this)) {
                        Intent intent = new Intent(BaseActivity.this, WishlistListActivity.class);
                        startActivity(intent);
                    } else {
                        gotoLogin();
                    }
                }
            });
        }
        if (btnDashboard != null) {
            btnDashboard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (User.userLoggedIn(BaseActivity.this)) {
                        Intent intent = new Intent(BaseActivity.this, UserDashboardActivity.class);
                        startActivity(intent);
                    } else {
                        gotoLogin();
                    }
                }
            });
        }
    }

    protected void gotoLogin() {
        Intent intent = new Intent(BaseActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
