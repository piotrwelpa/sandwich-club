package com.udacity.sandwichclub.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.R;

import java.util.List;

public class Sandwich {

    private String mainName;
    private List<String> alsoKnownAs = null;
    private String placeOfOrigin;
    private String description;
    private String image;
    private List<String> ingredients = null;

    /**
     * No args constructor for use in serialization
     */
    public Sandwich() {
    }

    public Sandwich(String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image, List<String> ingredients) {
        this.mainName = mainName;
        this.alsoKnownAs = alsoKnownAs;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public String getAlsoKnownAs() {
        StringBuilder alsoKnownAs = new StringBuilder();
        for( String i: this.alsoKnownAs){
            alsoKnownAs.append(i);
            if (this.alsoKnownAs.indexOf(i) != this.alsoKnownAs.size()-1)
                alsoKnownAs.append("\n");
        }
        return alsoKnownAs.toString();
    }

    public void setAlsoKnownAs(List<String> alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @BindingAdapter({"bind:image"})
    public static void loadImage(ImageView view, String image){
        Picasso.with(view.getContext())
                .load(image)
                .placeholder(R.drawable.placeholder)
                .into(view);
    }

    public String getIngredients() {
        StringBuilder ingredients = new StringBuilder();
        for(String i: this.ingredients){
            ingredients.append(i);
            if (this.ingredients.indexOf(i) != this.ingredients.size()-1)
                ingredients.append("\n");
        }
        return ingredients.toString();
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
