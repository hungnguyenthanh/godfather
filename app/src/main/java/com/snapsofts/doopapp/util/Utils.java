package com.snapsofts.doopapp.util;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by HungNT on 4/22/16.
 */
public class Utils {
    public static int dpToPx(Context context, int dp) {
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }
}
