package com.snapsofts.doopapp.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.snapsofts.doopapp.R;
import com.snapsofts.doopapp.ui.view.progressviews.CircleProgressBar;
import com.snapsofts.doopapp.ui.view.progressviews.OnProgressViewListener;

import butterknife.Bind;
import butterknife.ButterKnife;


public class SplashActivity extends AppCompatActivity {

    @Bind(R.id.circle_progress)
    CircleProgressBar circleProgress;
    @Bind(R.id.tvProgress)
    TextView tvProgress;
    @Bind(R.id.layoutProgress)
    FrameLayout layoutProgress;
    @Bind(R.id.logo)
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        System.gc();
        circleProgress.setRoundEdgeProgress(true);
        circleProgress.setWidthProgressBarLine(10);
        circleProgress.setTextSize(16);

        setupAnimation();
    }

    private void setupAnimation() {
        LayoutTransition layoutTransition = ((LinearLayout) findViewById(R.id.mainLayout)).getLayoutTransition();
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING);
        layoutTransition.setInterpolator(LayoutTransition.CHANGING, new DecelerateInterpolator(1.0f));
    }

    @Override
    protected void onResume() {
        super.onResume();
        circleProgress.setProgressIndeterminateAnimation(3000);
        circleProgress.setOnProgressViewListener(new OnProgressViewListener() {
            @Override
            public void onFinish() {
                tvProgress.setText("100%");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        layoutProgress.animate().alphaBy(0).setDuration(500).setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                layoutProgress.setVisibility(View.GONE);
                                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) logo.getLayoutParams();
                                lp.setMargins(0, -(int) getResources().getDimension(R.dimen.circle_loading_width), 0, 0);
                                logo.setLayoutParams(lp);
                            }
                        });
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
