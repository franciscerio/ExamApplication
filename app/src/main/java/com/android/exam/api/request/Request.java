package com.android.exam.api.request;

import com.android.exam.api.CJsonObjectRequest;
import com.android.exam.api.RequestResponseListener;
import com.android.volley.Response;
import com.android.volley.VolleyError;

public class Request {
    //This is my old implementation using volley

    protected CJsonObjectRequest mRequest;
    protected RequestResponseListener mListener;
    protected String mUrl;

    public Request(String urlPath, RequestResponseListener listener) {
        mUrl = urlPath;
        mListener = listener;
    }

    protected class ResponseListener implements Response.Listener<String> {
        @Override
        public void onResponse(String response) {
            if (mListener != null)
                mListener.requestCompleted(response);
        }
    }

    protected class ErrorListener implements Response.ErrorListener {
        @Override
        public void onErrorResponse(VolleyError error) {
            if (mListener != null)
                mListener.requestEndedWithError(error);
        }

    }


}