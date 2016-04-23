package com.snapsofts.doopapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

import org.json.JSONObject;

import java.util.Arrays;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dangnv on 4/21/16.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    CallbackManager callbackManager;

    private View btnLoginFacebook, btnSignupFacebook;
    private View btnLoginGmail;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initLoginWithFacebook();

        btnWishList.setVisibility(View.GONE);
        btnDashboard.setVisibility(View.GONE);

    }

    private void initLoginWithFacebook() {
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        String accessToken = loginResult.getAccessToken().getToken();
                        Log.i("accessToken", accessToken);

                        GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {

                                    @Override
                                    public void onCompleted(JSONObject object, GraphResponse response) {
                                        //TODO Call api login in here;
                                        Log.i("LoginActivity", object.toString());
                                        sharedPreferences.edit().putString(Constants.kUserToken, "faketoken").apply();
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

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


    @OnClick({R.id.btnLoginNow, R.id.btnSignupNow, R.id.btnLoginFacebook, R.id.btnSignupFacebook})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLoginNow:
                ButterKnife.findById(this, R.id.layoutLogin).setVisibility(View.VISIBLE);
                ButterKnife.findById(this, R.id.layoutSignup).setVisibility(View.GONE);
                break;
            case R.id.btnSignupNow:
                ButterKnife.findById(this, R.id.layoutLogin).setVisibility(View.GONE);
                ButterKnife.findById(this, R.id.layoutSignup).setVisibility(View.VISIBLE);
                break;
            case R.id.btnLoginFacebook:
            case R.id.btnSignupFacebook:
                LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "email", "user_birthday", "user_friends"));
                break;
            case R.id.btnLoginGmail:
                //TODO
                break;
        }
    }
}
