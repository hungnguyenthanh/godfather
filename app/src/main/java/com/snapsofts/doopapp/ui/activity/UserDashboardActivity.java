package com.snapsofts.doopapp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.snapsofts.doopapp.R;

/**
 * Created by dangnv on 4/21/16.
 */
public class UserDashboardActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        btnDashboard.setVisibility(View.GONE);
    }
}