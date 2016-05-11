package com.snapsofts.doopapp.data.model;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by HungNT on 5/11/16.
 */
public class Story {
    public static JSONArray sData;

    public static void getData(String data) {
        try {
            sData = new JSONArray(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static String getData(int chap) {
        try {
            return sData.getString(chap);
        } catch (JSONException e) {
            return "";
        }
    }
}
