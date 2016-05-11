package com.snapsofts.doopapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.snapsofts.doopapp.R;
import com.snapsofts.doopapp.data.model.Story;

import butterknife.ButterKnife;

public class ChooseCategoryRVAdapter extends RecyclerView.Adapter<ChooseCategoryRVAdapter.ViewHolder> {

    private ChooseCategory mChooseCategory;

    public ChooseCategoryRVAdapter() {
    }

    public void setOnItemClick(ChooseCategory category) {
        this.mChooseCategory = category;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_listview_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tvChapTitle.setText("Chương " + (position + 1));
    }

    @Override
    public int getItemCount() {
        return Story.sData.length();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        private TextView tvChapTitle;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvChapTitle = ButterKnife.findById(mView, R.id.tvChapTitle);

            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mChooseCategory != null) {
                        mChooseCategory.onItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }

    public interface ChooseCategory {
        void onItemClick(int pos);
    }
}
