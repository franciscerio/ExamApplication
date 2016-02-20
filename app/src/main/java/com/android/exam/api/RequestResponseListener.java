package com.android.exam.api;

import com.android.volley.VolleyError;

public interface RequestResponseListener {

    void requestCompleted(String response);

    void requestEndedWithError(VolleyError error);

}