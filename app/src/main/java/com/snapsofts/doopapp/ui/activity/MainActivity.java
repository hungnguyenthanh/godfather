package com.snapsofts.doopapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.snapsofts.doopapp.R;
import com.snapsofts.doopapp.ui.view.progressviews.CircleProgressBar;
import com.snapsofts.doopapp.ui.view.progressviews.OnProgressViewListener;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.circle_progress)
    CircleProgressBar circleProgress;
    @Bind(R.id.tvProgress)
    TextView tvProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        circleProgress.setRoundEdgeProgress(true);


//        new CountDownTimer(5000, 1000) {
//
//            @Override
//            public void onTick(long millisUntilFinished) {
//                int progress = (int) (circleProgress.getProgress() + 20);
//                circleProgress.setProgress(progress);
//                circleProgress.setProgressIndeterminateAnimation(1000);
//                tvProgress.setText(progress + "%");
//            }
//
//            @Override
//            public void onFinish() {
//                circleProgress.setProgress(100);
//                tvProgress.setText("100%");
//                circleProgress.setProgressIndeterminateAnimation(0);
//            }
//        }.start();

    }

    @Override
    protected void onResume() {
        super.onResume();
        circleProgress.setProgressIndeterminateAnimation(5000);
        circleProgress.setOnProgressViewListener(new OnProgressViewListener() {
            @Override
            public void onFinish() {
                tvProgress.setText("100%");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MainActivity.this, CategoryActivity.class));
                        MainActivity.this.finish();
                    }
                }, 500);

            }

            @Override
            public void onProgressUpdate(float progress) {
                tvProgress.setText((int) progress + "%");
            }
        });
    }
}
