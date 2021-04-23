package com.reciswipe.recipe.server.controller;

import com.reciswipe.recipe.IntegrationTesting.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/favorite-recipe")
@RestController
public class FavoriteRecipeController extends AbstractController{

    @Autowired
    public RecipeService recipeService;

    



}
