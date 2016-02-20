package com.android.exam.api;

import com.android.exam.models.Post;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class RequestResponseParser {


    //Parse Data
    public static ArrayList<Post> parseTask(String response) {
        ArrayList<Post> mPostList = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(response).getAsJsonArray();

        if (jsonArray != null) {
            //Get every array element
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject postObj = jsonArray.get(i).getAsJsonObject();
                Post post = new Gson().fromJson(postObj, Post.class);
                mPostList.add(post);
            }
        }

        return mPostList;
    }


}