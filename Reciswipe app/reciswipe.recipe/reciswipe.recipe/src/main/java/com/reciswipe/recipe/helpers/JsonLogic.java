package com.reciswipe.recipe.helpers;

import com.google.gson.Gson;

public class JsonLogic {


    private static Gson gson = new Gson();
    public static Object getObject(Class expected, String json) {
        Object result = null;
        try {
            result = gson.fromJson(json, expected);
        } catch (Exception error) {
            System.err.println("An error occurred while converting the object to a class");
            System.err.println(error);
        }
        return result;
    }
}
