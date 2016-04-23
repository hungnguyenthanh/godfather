package com.snapsofts.doopapp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.login.LoginManager;
import com.snapsofts.doopapp.R;
import com.snapsofts.doopapp.ui.activity.LoginActivity;

import org.json.JSONObject;

import java.util.Arrays;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dangnv on 4/23/16.
 */
public class LoginFragment extends Fragment {
    LoginActivity loginActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginActivity = (LoginActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, layout);


        return layout;
    }

    @OnClick({R.id.btnLoginGmail, R.id.btnLoginFacebook, R.id.btnSignupNow})
    void click(View view) {
        if (view.getId() == R.id.btnLoginGmail) {
            loginActivity.showLoginEmailFragment();

        } else if (view.getId() == R.id.btnLoginFacebook) {
            loginActivity.loginWithFacebook(new LoginActivity.LoginFacebookCompletion() {
                @Override
                public void onCompleted(JSONObject jsonObject) {
                    //TODO
                }
            });
        } else if (view.getId() == R.id.btnSignupNow) {
            loginActivity.showSignupFragment();
        }
    }
}
