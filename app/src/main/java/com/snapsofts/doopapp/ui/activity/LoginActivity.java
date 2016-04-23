package com.snapsofts.doopapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.snapsofts.doopapp.R;
import com.snapsofts.doopapp.commons.Constants;
import com.snapsofts.doopapp.ui.fragment.LoginEmailFragment;
import com.snapsofts.doopapp.ui.fragment.LoginFragment;
import com.snapsofts.doopapp.ui.fragment.SignupFragment;

import org.json.JSONObject;

import java.util.Arrays;

import butterknife.ButterKnife;

/**
 * Created by dangnv on 4/21/16.
 */
public class LoginActivity extends BaseActivity {
    CallbackManager callbackManager;

    private LoginFacebookCompletion loginFacebookCompletion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initLoginWithFacebook();

        btnWishList.setVisibility(View.GONE);
        btnDashboard.setVisibility(View.GONE);

        showLoginFragment();
    }

    public void showLoginFragment() {
        LoginFragment loginFragment = new LoginFragment();
        showFragment(loginFragment, false);
    }

    public void showSignupFragment() {
        SignupFragment signupFragment = new SignupFragment();
        showFragment(signupFragment, true);
    }

    public void showLoginEmailFragment() {
        LoginEmailFragment loginEmailFragment = new LoginEmailFragment();
        showFragment(loginEmailFragment, true);
    }

    private void showFragment(Fragment fg, boolean addtoBackStack) {
        String backStateName = fg.getClass().getName();

        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped) { //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.contentView, fg);
            if (addtoBackStack) {
                ft.addToBackStack(backStateName);
            }
            ft.commit();
        }
    }

    public void initLoginWithFacebook() {
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {

                                    @Override
                                    public void onCompleted(JSONObject object, GraphResponse response) {
                                        //TODO should modify this
                                        Log.i("LoginActivity", object.toString());
                                        sharedPreferences.edit().putString(Constants.kUserToken, "faketoken").apply();
                                        if (loginFacebookCompletion != null) {
                                            loginFacebookCompletion.onCompleted(object);
                                        }

                                        finish();
                                    }
                                }
                        );
                        Bundle parameters = new Bundle();
                        request.setParameters(parameters);
                        request.executeAsync();
                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException error) {

                    }
                }
        );
    }

    public void loginWithFacebook(LoginFacebookCompletion completion) {
        loginFacebookCompletion = completion;
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "email", "user_birthday", "user_friends"));
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public interface LoginFacebookCompletion {
        public void onCompleted(JSONObject jsonObject);
    }
}
