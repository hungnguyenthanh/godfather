package com.snapsofts.doopapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.snapsofts.doopapp.R;
import com.snapsofts.doopapp.data.model.Category;
import com.snapsofts.doopapp.ui.adapter.ChooseCategoryRVAdapter;
import com.snapsofts.doopapp.ui.view.DividerItemDecoration;
import com.snapsofts.doopapp.ui.view.VerticalSpaceItemDecoration;
import com.snapsofts.doopapp.util.Utils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChooseCategoryActivity extends AppCompatActivity {

    @Bind(R.id.listCategory)
    RecyclerView listCategory;
    private ChooseCategoryRVAdapter mlistCategoryAdapter;
    private ArrayList<Category> listCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);

        initDemo();

        mlistCategoryAdapter = new ChooseCategoryRVAdapter(listCategories);
        listCategory.setLayoutManager(new LinearLayoutManager(this));

        listCategory.addItemDecoration(new VerticalSpaceItemDecoration(Utils.dpToPx(this, 6)));
        listCategory.setAdapter(mlistCategoryAdapter);
    }

    private void initDemo() {
        listCategories = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Category category = new Category();
            category.name = "Category " + i;
            category.categoryId = "" + i;
            listCategories.add(category);
        }
    }

    @OnClick(R.id.btnFood)
    public void onClick() {
        startActivity(new Intent(ChooseCategoryActivity.this, HomeActivity.class));
    }
}
