package com.snapsofts.doopapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.snapsofts.doopapp.R;
import com.snapsofts.doopapp.ui.view.progressviews.CircleProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.circle_progress)
    CircleProgressBar circleProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        circleProgress.setRoundEdgeProgress(true);
    }
}
