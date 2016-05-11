package com.snapsofts.doopapp.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.snapsofts.doopapp.R;
import com.snapsofts.doopapp.commons.Constants;
import com.snapsofts.doopapp.data.model.Story;
import com.snapsofts.doopapp.ui.adapter.ChooseCategoryRVAdapter;
import com.snapsofts.doopapp.ui.view.VerticalSpaceItemDecoration;
import com.snapsofts.doopapp.ui.view.progressviews.CircleProgressBar;
import com.snapsofts.doopapp.ui.view.progressviews.OnProgressViewListener;
import com.snapsofts.doopapp.util.Utils;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SplashActivity extends AppCompatActivity implements ChooseCategoryRVAdapter.ChooseCategory {

    @Bind(R.id.circle_progress)
    CircleProgressBar circleProgress;
    @Bind(R.id.tvProgress)
    TextView tvProgress;
    @Bind(R.id.layoutProgress)
    FrameLayout layoutProgress;
    @Bind(R.id.listCategory)
    RecyclerView listView;

    private ChooseCategoryRVAdapter mlistCategoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        circleProgress.setRoundEdgeProgress(true);
        circleProgress.setWidthProgressBarLine(10);
        circleProgress.setTextSize(16);

        setupAnimation();

        try {
            Story.getData(Utils.readStringFromAssets(getApplicationContext(), Constants.DATA_FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }

        mlistCategoryAdapter = new ChooseCategoryRVAdapter();
        mlistCategoryAdapter.setOnItemClick(this);
        initDemo();


    }

    private void initDemo() {
        circleProgress.setProgressIndeterminateAnimation(3000);
        circleProgress.setOnProgressViewListener(new OnProgressViewListener() {
            @Override
            public void onFinish() {
                tvProgress.setText("100%");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        layoutProgress.animate().alpha(0).setDuration(500).setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                layoutProgress.setVisibility(View.GONE);
                                findViewById(R.id.listLayout).setVisibility(View.VISIBLE);


                                listView.setLayoutManager(new LinearLayoutManager(SplashActivity.this));
                                listView.addItemDecoration(new VerticalSpaceItemDecoration(Utils.dpToPx(SplashActivity.this, (int) getResources().getDimension(R.dimen._10dp))));
                                listView.setAdapter(mlistCategoryAdapter);
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

    private void setupAnimation() {
        LayoutTransition layoutTransition = ((LinearLayout) findViewById(R.id.layoutAction)).getLayoutTransition();
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING);
        layoutTransition.setInterpolator(LayoutTransition.CHANGING, new DecelerateInterpolator(1.0f));
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    public void onItemClick(int pos) {
        startReadingActivity(pos);
    }

    private void startReadingActivity(int pos) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra(HomeActivity.EXTRA_CHAP, pos);
        startActivity(intent);
    }
}
