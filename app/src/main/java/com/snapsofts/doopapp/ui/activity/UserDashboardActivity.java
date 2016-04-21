package com.snapsofts.doopapp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.snapsofts.doopapp.R;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dangnv on 4/21/16.
 */
public class UserDashboardActivity extends BaseActivity {
    @Bind(R.id.changeCategoryLayout)
    LinearLayout changeCategoryLayout;

    @Bind(R.id.tvUpdateCategory)
    TextView tvUpdateCategory;

    @Bind(R.id.tvUpgradeEmail)
    TextView tvUpgradeEmail;

    @Bind(R.id.tvChangePassword)
    TextView tvChangePassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        ButterKnife.bind(this);

        btnDashboard.setVisibility(View.GONE);
    }

    @OnClick(R.id.tvUpdateCategory)
    void updateCategoryClick() {

    }

    @OnClick(R.id.tvUpgradeEmail)
    void upgradeEmailClick() {

    }

    @OnClick(R.id.tvChangePassword)
    void changePasswordClick() {

    }


}
