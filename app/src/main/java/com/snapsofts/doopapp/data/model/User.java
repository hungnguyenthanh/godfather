package com.snapsofts.doopapp.data.model;

/**
 * Created by dangnv on 4/21/16.
 */
public class User {
    public String userId;
    public String userEmail;

    public static User currentUser() {
        return null;
    }

    public static boolean userLoggedIn() {
        if (currentUser() == null) {
            return false;
        }
        return true;
    }
}
