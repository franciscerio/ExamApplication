package com.android.exam.api;

import com.android.exam.api.request.GetRequest;

/**
 * Created by Cerio on 6/22/15.
 */
public class APIRequestManager {

    public static final String HOST = "http://mootask.com";
    public static final String API = "api";
    public static final String TASK_CONTROLLER = "taskcontroller";
    public static final String PROFILE_CONTROLLER = "profilecontroller";

    //REQUEST URL
    public static final String IMAGE_URL = "%s/%s/showtaskimagethumbnail?id=%s";
    public static final String COMPANY_LOGO = "%s/%s/showlogobyid?id=%s";
    public static final String TASK_REQUEST = "%s/%s/%s/tasks?from=0&max=20";


    public static void getTaskRequest(RequestResponseListener listener) {
        String urlPath = String.format(APIRequestManager.TASK_REQUEST, APIRequestManager.HOST, APIRequestManager.API, APIRequestManager.TASK_CONTROLLER);
        new GetRequest(urlPath, listener).sendRequest();
    }

}