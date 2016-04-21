package com.snapsofts.doopapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.snapsofts.doopapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChooseCategoryActivity extends AppCompatActivity {

    @Bind(R.id.listCategory)
    ListView listCategory;
    private CategoryAdapter mlistCategoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);

        mlistCategoryAdapter = new CategoryAdapter();
        listCategory.setAdapter(mlistCategoryAdapter);
    }

    @OnClick(R.id.btnFood)
    public void onClick() {
        startActivity(new Intent(ChooseCategoryActivity.this, HomeActivity.class));
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
                view = LayoutInflater.from(ChooseCategoryActivity.this).inflate(R.layout.item_listview_category, null);
            }

            return view;
        }
    }
}
