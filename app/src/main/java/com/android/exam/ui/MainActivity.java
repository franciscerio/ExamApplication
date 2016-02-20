package com.android.exam.ui;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.exam.R;
import com.android.exam.api.APIRequestManager;
import com.android.exam.api.RequestResponseListener;
import com.android.exam.api.RequestResponseParser;
import com.android.exam.base.BaseActivity;
import com.android.exam.models.Post;
import com.android.exam.ui.adapters.PostAdapter;
import com.android.volley.VolleyError;

import java.util.ArrayList;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    @Bind(R.id.rvTask)
    RecyclerView mRecyclerView;

    private LinearLayoutManager mLinearLayoutManager;
    private ArrayList<Post> mPostList;
    private PostAdapter mAdapter;

    @Override
    public int getLayoutResources() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    private void initialize() {
        mPostList = new ArrayList<>();
        mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.addItemDecoration(new SpacesItemDecorationExplore(10));
        mAdapter = new PostAdapter(this, mPostList);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);

        //GET ALL POST REQUEST
        APIRequestManager.getTaskRequest(GetTaskRequest);
    }

    private RequestResponseListener GetTaskRequest = new RequestResponseListener() {
        @Override
        public void requestCompleted(String response) {
            //Data will be displayed here!
            mPostList.addAll(RequestResponseParser.parseTask(response));
            mAdapter.notifyDataSetChanged();
        }

        @Override
        public void requestEndedWithError(VolleyError error) {
            Toast.makeText(MainActivity.this, "error " + error.getMessage(), Toast.LENGTH_LONG).show();
        }
    };

    //for recyclerview item spacing
    class SpacesItemDecorationExplore extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecorationExplore(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.bottom = space;
            outRect.top = space;
            outRect.right = space;
            outRect.left = space;
        }
    }
}