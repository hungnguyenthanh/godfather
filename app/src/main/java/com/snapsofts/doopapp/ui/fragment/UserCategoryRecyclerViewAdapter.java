package com.snapsofts.doopapp.ui.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.snapsofts.doopapp.R;
import com.snapsofts.doopapp.data.model.Category;

public class UserCategoryRecyclerViewAdapter extends RecyclerView.Adapter<UserCategoryRecyclerViewAdapter.ViewHolder> {

    //    private final List<Category> mValues;
    private Context mContext;

    public UserCategoryRecyclerViewAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
//        Picasso.with(mContext).load(R.drawable.img_menu_sample).into(holder.imgPicture);
//        holder.mItem = mValues.get(position);
//        holder.mIdView.setText(mValues.get(position).id);
//        holder.mContentView.setText(mValues.get(position).content);

//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (null != mListener) {
//                    // Notify the active callbacks interface (the activity, if the
//                    // fragment is attached to one) that an item has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
//        return mValues.size();
        return 50;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        //        public final TextView mIdView;
        public final ImageView imgPicture;
        //        public final TextView mContentView;
        public Category mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            imgPicture = (ImageView) view.findViewById(R.id.imgPicture);
//            mContentView = (TextView) view.findViewById(R.id.content);
        }

//        @Override
//        public String toString() {
//            return super.toString() + " '" + mContentView.getText() + "'";
//        }
    }
}
