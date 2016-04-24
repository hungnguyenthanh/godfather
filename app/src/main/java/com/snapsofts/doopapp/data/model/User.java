package com.snapsofts.doopapp.data.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.snapsofts.doopapp.commons.CommonUtils;
import com.snapsofts.doopapp.commons.Constants;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dangnv on 4/21/16.
 */
public class User {
    public String userId;
    public String email;
    public String name;
    public String facebooId;
    public String location;
    public String gender;
    public String facebookAvatarUrl;
    public String firstname;
    public String lastname;

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

    public static User getCurrentUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        String userJsonString = sharedPreferences.getString(Constants.kUserProfile, "{}");
        try {
            JSONObject jsonObject = new JSONObject(userJsonString);
            User user = new User();
            user.email = jsonObject.getString("email");
            user.facebooId = jsonObject.getString("id");
            user.facebookAvatarUrl = CommonUtils.getFacebookUserAvatar(user.facebooId);
            if (jsonObject.has("location")) {
                user.location = jsonObject.getString("location");
            } else {
                user.location = "";
            }
            if (jsonObject.has("gender")) {
                user.gender = jsonObject.getString("gender");
            }
            if (jsonObject.has("first_name")) {
                user.firstname = jsonObject.getString("first_name");
            }
            if (jsonObject.has("last_name")) {
                user.lastname = jsonObject.getString("last_name");
            }
            user.name = user.firstname + " " + user.lastname;

            return user;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
