package com.snapsofts.doopapp.ui.activity;

import android.animation.LayoutTransition;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.snapsofts.doopapp.R;
import com.transitionseverywhere.TransitionManager;
import com.transitionseverywhere.TransitionUtils;

import org.w3c.dom.Text;

/**
 * Created by dangnv on 4/21/16.
 */
public class UserDashboardActivity extends BaseActivity implements View.OnClickListener {
    LinearLayout changeCategoryLayout;
    TextView btnUpdateCategory;
    TextView btnUpgradeEmail;
    TextView btnChangePassword;

    private EditText edtEmail;
    private EditText edtPassword;

    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        btnDashboard.setVisibility(View.GONE);

        changeCategoryLayout = (LinearLayout) findViewById(R.id.changeCategoryLayout);

        btnUpdateCategory = (TextView) findViewById(R.id.tvUpdateCategory);
        btnUpdateCategory.setOnClickListener(this);

        btnChangePassword = (TextView) findViewById(R.id.tvChangePassword);
        btnChangePassword.setOnClickListener(this);

        btnUpgradeEmail = (TextView) findViewById(R.id.tvUpgradeEmail);
        btnUpgradeEmail.setOnClickListener(this);

        edtEmail = (EditText) findViewById(R.id.edtUpgradeEmail);
        edtPassword = (EditText) findViewById(R.id.edtChangePassword);

        listView = (ListView) findViewById(R.id.listCategory);
        listView.setDividerHeight(0);

        setupAnimation();
    }

    private void setupAnimation() {

        LayoutTransition layoutTransition = changeCategoryLayout.getLayoutTransition();
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING);
        layoutTransition = ((ViewGroup) changeCategoryLayout.getParent()).getLayoutTransition();
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING);
    }

    @Override
    public void onClick(View view) {
        if (view == btnUpdateCategory) {
            if (btnUpdateCategory.isSelected()) {
                btnUpdateCategory.setSelected(false);
                btnUpdateCategory.setText(getString(R.string.select));
                changeCategoryLayout.setSelected(false);

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                changeCategoryLayout.setLayoutParams(layoutParams);
                listView.setAdapter(null);
            } else {
                btnUpdateCategory.setSelected(true);
                btnUpdateCategory.setText(getString(R.string.save));
                changeCategoryLayout.setSelected(true);

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
                layoutParams.weight = 1;
                changeCategoryLayout.setLayoutParams(layoutParams);

                listView.setAdapter(new CategoryAdapter());
            }

        } else if (view == btnUpgradeEmail) {
            btnUpgradeEmail.setSelected(!btnUpgradeEmail.isSelected());
            edtEmail.setEnabled(btnUpgradeEmail.isSelected());
            if (btnUpgradeEmail.isSelected()) {
                edtEmail.requestFocus();
                edtEmail.setSelection(edtEmail.getText().length());
            } else {

            }
        } else if (view == btnChangePassword) {
            btnChangePassword.setSelected(!btnChangePassword.isSelected());
            edtPassword.setEnabled(btnChangePassword.isSelected());
            if (btnChangePassword.isSelected()) {
                edtPassword.setText("");
                edtPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                edtPassword.requestFocus();
            } else {
                edtPassword.setText(getString(R.string.password_change));
                edtPassword.setInputType(InputType.TYPE_CLASS_TEXT);
            }
        }
    }

    class CategoryAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(UserDashboardActivity.this).inflate(R.layout.item_category_dashboard, null);
            }

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View iconSelect = view.findViewById(R.id.iconSelect);
                    view.setSelected(!view.isSelected());
                    iconSelect.setSelected(view.isSelected());
                }
            });

            return view;
        }
    }
}
