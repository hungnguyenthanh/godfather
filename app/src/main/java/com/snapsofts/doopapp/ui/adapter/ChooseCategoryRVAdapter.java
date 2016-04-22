package com.snapsofts.doopapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.snapsofts.doopapp.R;
import com.snapsofts.doopapp.data.model.Category;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class ChooseCategoryRVAdapter extends RecyclerView.Adapter<ChooseCategoryRVAdapter.ViewHolder> {

    private ArrayList<Category> mValues = new ArrayList<>();

    public ChooseCategoryRVAdapter(ArrayList<Category> listCategories) {
        mValues = listCategories;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_listview_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public ImageView iconTick;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            iconTick = ButterKnife.findById(mView, R.id.icon_tick);

            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Category category = mValues.get(getAdapterPosition());
                    category.selected = !category.selected;
                    iconTick.setSelected(category.selected);
                }
            });
        }
    }
}
