package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        /* Initialize variable used in Sandwitch constructor */
        String mainName;
        List<String> alsoKnownAs = null;
        String placeOfOrigin;
        String description;
        String image;
        List<String> ingredients = null;

        JSONObject rootObject;
        try {
            rootObject = new JSONObject(json);
            description = rootObject.getString("description");
            image = rootObject.getString("image");
            placeOfOrigin = rootObject.getString("placeOfOrigin");

            JSONObject name = rootObject.getJSONObject("name");
            mainName = name.getString("mainName");
            JSONArray aka = name.getJSONArray("alsoKnownAs");
            for (int i = 0; i < aka.length(); i++){
                alsoKnownAs.add(aka.getString(i));
            }
            JSONArray ingredientsJson = rootObject.getJSONArray("ingredients");
            for (int i = 0; i < ingredientsJson.length(); i++){
                ingredients.add(ingredientsJson.getString(i));
            }
        } catch (JSONException e) {
            Log.e(JsonUtils.class.getName(), "Error while parsing JSONObject");
            e.printStackTrace();
            return null;
        }

        return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
    }
}
