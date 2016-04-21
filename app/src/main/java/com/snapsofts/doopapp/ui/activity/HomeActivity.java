package com.snapsofts.doopapp.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.snapsofts.doopapp.R;
import com.snapsofts.doopapp.data.model.User;
import com.snapsofts.doopapp.util.SwipeGestureDetector;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @Bind(R.id.btnWishList)
    TextView btnWishList;
    @Bind(R.id.layout1)
    View layoutView;
    private GestureDetector mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Animation exitAnimation = AnimationUtils.loadAnimation(this, R.anim.exit_to_top);
        final Animation inAnimation = AnimationUtils.loadAnimation(this, R.anim.in_from_top);

        mDetector = new GestureDetector(this, new SwipeGestureDetector(
                new SwipeGestureDetector.OnSwipeListener() {
                    @Override
                    public void onSwipe(int slope) {
                        switch (slope) {
                            case SwipeGestureDetector.TOP:
                                layoutView.startAnimation(exitAnimation);
                                break;
                            case SwipeGestureDetector.DOWN:
                                layoutView.startAnimation(inAnimation);
                                break;
                        }
                    }
                }));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mDetector.onTouchEvent(event);
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
