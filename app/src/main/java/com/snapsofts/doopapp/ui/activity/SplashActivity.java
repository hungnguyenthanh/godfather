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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.snapsofts.doopapp.R;
import com.snapsofts.doopapp.data.model.Category;
import com.snapsofts.doopapp.ui.adapter.ChooseCategoryRVAdapter;
import com.snapsofts.doopapp.ui.view.VerticalSpaceItemDecoration;
import com.snapsofts.doopapp.ui.view.progressviews.CircleProgressBar;
import com.snapsofts.doopapp.ui.view.progressviews.OnProgressViewListener;
import com.snapsofts.doopapp.util.Utils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SplashActivity extends AppCompatActivity {

    @Bind(R.id.circle_progress)
    CircleProgressBar circleProgress;
    @Bind(R.id.tvProgress)
    TextView tvProgress;
    @Bind(R.id.layoutProgress)
    FrameLayout layoutProgress;
    @Bind(R.id.logo)
    ImageView logo;

    @Bind(R.id.btnGoHome)
    View btnGoHome;

    @Bind(R.id.listCategory)
    RecyclerView listView;

    private ChooseCategoryRVAdapter mlistCategoryAdapter;

    ArrayList<Category> listCategories;

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

        initDemo();
        mlistCategoryAdapter = new ChooseCategoryRVAdapter(listCategories);


    }

    private void initDemo() {
        listCategories = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Category category = new Category();
            category.name = "Category " + i;
            category.categoryId = "" + i;
            listCategories.add(category);
        }

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

    @OnClick(R.id.btnGoHome)
    public void goHomeClick(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
