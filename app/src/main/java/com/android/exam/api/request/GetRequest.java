package com.android.exam.api.request;

import com.android.exam.ExamApplication;
import com.android.exam.api.CJsonObjectRequest;
import com.android.exam.api.RequestResponseListener;

public class GetRequest extends Request {

    public static final String TAG = "GetRequest:tag";

    //Fetching get method data
    public GetRequest(String urlPath, RequestResponseListener listener) {
        super(urlPath, listener);
    }

    //Sending request to server
    public void sendRequest() {
        mRequest = new CJsonObjectRequest(com.android.volley.Request.Method.GET, mUrl, new ResponseListener(), new ErrorListener());
        mRequest.setPriority(com.android.volley.Request.Priority.IMMEDIATE);
        ExamApplication.getInstance().addToRequestQueue(mRequest, TAG);
    }

}