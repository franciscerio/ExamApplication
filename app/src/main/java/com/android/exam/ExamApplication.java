package com.android.exam;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by franceriu on 2/20/16.
 */
public class ExamApplication extends Application {

    public static ExamApplication mInstance;
    private static String TAG = "ExamApplication";
    private static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static ExamApplication getInstance() {
        return mInstance;
    }

    //Volley
    public RequestQueue getRequestQueue() {
        if (queue == null) {
            queue = Volley.newRequestQueue(this);
        }

        return queue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

}
