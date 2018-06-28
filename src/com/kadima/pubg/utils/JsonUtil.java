package com.kadima.pubg.utils;

import com.google.gson.Gson;

public class JsonUtil {

    private static Gson gson = new Gson();

    public static String toJson(Object json) {
        return gson.toJson(json);
    }
}
