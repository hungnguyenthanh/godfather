package com.snapsofts.doopapp.data.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.snapsofts.doopapp.commons.Constants;

/**
 * Created by dangnv on 4/21/16.
 */
public class User {
    public String userId;
    public String userEmail;

    public static User currentUser() {
        return null;
    }

    public static boolean userLoggedIn(Context context) {
        String token = getUserToken(context);
        if (token != null && token.length() > 0) {
            return true;
        }
        return false;
    }

    public static String getUserToken(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(Constants.kUserToken, "");
    }
}
