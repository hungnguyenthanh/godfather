package com.snapsofts.doopapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

import com.snapsofts.doopapp.R;
import com.snapsofts.doopapp.data.model.Story;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    public static final String EXTRA_CHAP = "EXTRA_CHAP";

    @Bind(R.id.tvContent)
    TextView tvContent;
    @Bind(R.id.btnWishList)
    TextView btnWishList;

    private int chap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        chap = getIntent().getIntExtra(EXTRA_CHAP, 0);

        btnWishList.setText("Chương " + (chap + 1));

        tvContent.setText(Html.fromHtml(Story.getData(chap)));

    }

    @OnClick(R.id.btnDashboard)
    public void onClick() {
        finish();
    }
}
