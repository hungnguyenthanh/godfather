package com.snapsofts.doopapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.snapsofts.doopapp.R;
import com.snapsofts.doopapp.commons.Constants;
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
    @Bind(R.id.btnPrev)
    ImageView btnPrev;
    @Bind(R.id.btnNext)
    ImageView btnNext;
    @Bind(R.id.cbDay)
    CheckBox cbDay;

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
        checkNavigation();
        setViewStory();

        cbDay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constants.isLightTheme = isChecked;
                setViewTheme();
            }
        });

        cbDay.setChecked(Constants.isLightTheme);

    }

    private void setViewTheme() {
        if (Constants.isLightTheme) {
            tvContent.setTextColor(0xff343434);
            tvContent.setBackgroundColor(0xFFEAEAEA);
        } else {
            tvContent.setTextColor(0x80ffffff);
            tvContent.setBackgroundColor(0xff343434);
        }
    }

    @OnClick(R.id.btnWishList)
    public void onClick() {
        finish();
    }


    @OnClick({R.id.btnPrev, R.id.btnNext})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPrev:
                if (chap > 0)
                    chap--;
                break;
            case R.id.btnNext:
                if (chap < Story.sData.length() - 1)
                    chap++;
                break;
        }
        checkNavigation();
        setViewStory();
    }

    public void checkNavigation() {
        if (chap == 0) {
            btnPrev.setVisibility(View.GONE);
        } else if (chap == Story.sData.length() - 1) {
            btnNext.setVisibility(View.GONE);
        } else {
            btnPrev.setVisibility(View.VISIBLE);
            btnNext.setVisibility(View.VISIBLE);
        }
    }

    public void setViewStory() {
        btnWishList.setText("Chương " + (chap + 1));
        tvContent.setText(Html.fromHtml(Story.getData(chap)));
    }
}
