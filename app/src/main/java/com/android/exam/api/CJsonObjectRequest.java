package com.android.exam.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class CJsonObjectRequest extends StringRequest {

    private Request.Priority lowPriority = Priority.IMMEDIATE;

    public CJsonObjectRequest(int method, String url,
                              Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }


    @Override
    public Priority getPriority() {
        return lowPriority;
    }

    public void setPriority(Priority priority) {
        lowPriority = priority;
    }


}