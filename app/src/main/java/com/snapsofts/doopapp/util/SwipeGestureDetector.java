package com.snapsofts.doopapp.util;

import android.view.GestureDetector;
import android.view.MotionEvent;

public class SwipeGestureDetector extends GestureDetector.SimpleOnGestureListener {

    private static final String LOGTAG = "hung";
    public static final int TOP = 1;
    public static final int LEFT = 2;
    public static final int DOWN = 3;
    public static final int RIGHT = 4;

    private OnSwipeListener mOnSwipeListener;

    public SwipeGestureDetector(OnSwipeListener onSwipeListener) {
        this.mOnSwipeListener = onSwipeListener;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2,
                           float velocityX, float velocityY) {

        switch (getSlope(e1.getX(), e1.getY(), e2.getX(), e2.getY())) {
            case 1:
                mOnSwipeListener.onSwipe(TOP);
                return true;
            case 2:
                mOnSwipeListener.onSwipe(LEFT);
                return true;
            case 3:
                mOnSwipeListener.onSwipe(DOWN);
                return true;
            case 4:
                mOnSwipeListener.onSwipe(RIGHT);
                return true;
        }
        return false;
    }

    private int getSlope(float x1, float y1, float x2, float y2) {
        Double angle = Math.toDegrees(Math.atan2(y1 - y2, x2 - x1));
        if (angle > 45 && angle <= 135)
            // top
            return 1;
        if (angle >= 135 && angle < 180 || angle < -135 && angle > -180)
            // left
            return 2;
        if (angle < -45 && angle >= -135)
            // down
            return 3;
        if (angle > -45 && angle <= 45)
            // right
            return 4;
        return 0;
    }


    public interface OnSwipeListener {
        /**
         * return swipe slope
         *
         * @param slope one of @TOP @LEFT @RIGHT @DOWN
         */
        public void onSwipe(int slope);
    }
}