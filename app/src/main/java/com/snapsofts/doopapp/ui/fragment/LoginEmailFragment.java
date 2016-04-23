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

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dangnv on 4/23/16.
 */
public class LoginEmailFragment extends Fragment {
    LoginActivity loginActivity;
    @Bind(R.id.edtEmail)
    EditText edtEmail;
    @Bind(R.id.edtPassword)
    EditText edtPassword;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginActivity = (LoginActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_login_email, container, false);
        ButterKnife.bind(this, layout);

        return layout;
    }

    @OnClick({R.id.btnGoLogin, R.id.btnSignupNow})
    void click(View view) {
        if (view.getId() == R.id.btnGoLogin) {
            //TODO - call api in here;
        } else if (view.getId() == R.id.btnSignupNow) {
            loginActivity.showSignupFragment();
        }
    }
}
