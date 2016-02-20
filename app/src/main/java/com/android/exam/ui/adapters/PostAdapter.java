package com.android.exam.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.exam.R;
import com.android.exam.api.APIRequestManager;
import com.android.exam.models.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int POST_TYPE = 0;
    private ArrayList<Post> mPostList;
    private Context mContext;
    private LayoutInflater mInflater;

    public PostAdapter(Context mContext, ArrayList<Post> mPostList) {
        this.mPostList = mPostList;
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == POST_TYPE) {
            View view = mInflater.inflate(R.layout.item_post, parent, false);
            PostViewHolder holder = new PostViewHolder(view);
            return holder;
        }

        throw new RuntimeException("There is no type that matches the type " + viewType + " + make sure your using types    correctly");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof PostViewHolder) {
            PostViewHolder.bindPostViewHolder((PostViewHolder) holder, mContext, mPostList.get(position), position);
        }
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return POST_TYPE;
    }

    static class PostViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.ivPostCompanyImage)
        ImageView mIvCompanyImage;

        @Bind(R.id.ivPostImage)
        ImageView mIvPostImage;

        @Bind(R.id.tvCompanyTitle)
        TextView mTvCompanyTitle;

        @Bind(R.id.tvCompanyName)
        TextView mTvCompanyName;

        public PostViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        //Data will be posted here
        public static void bindPostViewHolder(PostViewHolder holder, Context context, Post post, int position) {
            if (holder.mIvCompanyImage != null) {
                //Checker for logo if available or not
                if (post.getCompany().getLogo().size() > 0) {
                    String companyLogo = String.format(APIRequestManager.COMPANY_LOGO, APIRequestManager.HOST, APIRequestManager.PROFILE_CONTROLLER, String.valueOf(post.getCompany().getLogo().get(0).getEntityID()));
                    Picasso.with(context).load(companyLogo).into(holder.mIvCompanyImage);
                }
            }

            if (holder.mIvPostImage != null) {
                String imagePost = String.format(APIRequestManager.IMAGE_URL, APIRequestManager.HOST, APIRequestManager.TASK_CONTROLLER, String.valueOf(post.getEntityId()));
                Picasso.with(context).load(imagePost).into(holder.mIvPostImage);
            }

            if (holder.mTvCompanyTitle != null) {
                holder.mTvCompanyTitle.setText(post.getTitle());
            }

            if (holder.mTvCompanyName != null) {
                holder.mTvCompanyName.setText(post.getCompany().getName());
            }
        }
    }

}