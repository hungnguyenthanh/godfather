package com.snapsofts.doopapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.snapsofts.doopapp.R;

import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by dangnv on 4/21/16.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    CallbackManager callbackManager;

    private View btnLoginFacebook;
    private View btnLoginGmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initLoginWithFacebook();

        btnLoginFacebook = findViewById(R.id.btnLoginFacebook);
        btnLoginGmail = findViewById(R.id.btnLoginGmail);

        btnLoginFacebook.setOnClickListener(this);
        btnLoginGmail.setOnClickListener(this);
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
                                        Log.i("LoginActivity", object.toString());
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
    public void onClick(View view) {
        if (view == btnLoginFacebook) {
            LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "email", "user_birthday", "user_friends"));
        } else if (view == btnLoginGmail) {
            //TODO
        }
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
