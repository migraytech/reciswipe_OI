package com.reciswipe.recipe.server.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String recipes;

    @NotNull
    private Kitchen kitchens;


    public Recipe()
    {

    }

    public Recipe( String name, String description, String recipes, Kitchen kitchens) {
        this.name = name;
        this.description = description;
        this.recipes = recipes;
        this.kitchens = kitchens;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRecipes() {
        return recipes;
    }

    public Kitchen getKitchens() {
        return kitchens;
    }
}
