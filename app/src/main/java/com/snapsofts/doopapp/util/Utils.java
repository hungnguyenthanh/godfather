package com.snapsofts.doopapp.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by HungNT on 4/22/16.
 */
public class Utils {
    public static int dpToPx(Context context, int dp) {
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    //For open keyboard
    public static void OpenKeyBoard(Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    //For close keyboard
    public static void CloseKeyBoard(Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

    public static String readStringFromAssets(Context context, String name) throws IOException {
        StringBuilder buf = new StringBuilder();
        InputStream json = context.getAssets().open(name);
        BufferedReader in =
                new BufferedReader(new InputStreamReader(json, "UTF-8"));
        String str;

        while ((str = in.readLine()) != null) {
            buf.append(str);
        }

        in.close();

        return buf.toString();
    }
}
