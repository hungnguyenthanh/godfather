package com.snapsofts.doopapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.snapsofts.doopapp.R;
import com.snapsofts.doopapp.ui.activity.LoginActivity;

import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dangnv on 4/23/16.
 */
public class SignupFragment extends Fragment {
    LoginActivity loginActivity;
    @Bind(R.id.edtEmail)
    EditText edtEmail;
    @Bind(R.id.edtPassword)
    EditText edtPassword;
    @Bind(R.id.edtName)
    EditText edtName;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginActivity = (LoginActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_signup_email, container, false);
        ButterKnife.bind(this, layout);

        return layout;
    }

    @OnClick({R.id.btnSignupFacebook, R.id.btnLoginNow})
    void click(View view) {
        if (view.getId() == R.id.btnSignupFacebook) {
            loginActivity.loginWithFacebook(new LoginActivity.LoginFacebookCompletion() {
                @Override
                public void onCompleted(JSONObject jsonObject) {
                    //TODO
                }
            });
        } else if (view.getId() == R.id.btnLoginNow) {
            loginActivity.showLoginEmailFragment();
        } else if (view.getId() == R.id.btnSignup) {
            //TODO
        }
    }
}
