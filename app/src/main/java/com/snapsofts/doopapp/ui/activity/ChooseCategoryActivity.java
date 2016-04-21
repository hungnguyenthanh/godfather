package com.snapsofts.doopapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.snapsofts.doopapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChooseCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnFood)
    public void onClick() {
        startActivity(new Intent(ChooseCategoryActivity.this, HomeActivity.class));
    }
}