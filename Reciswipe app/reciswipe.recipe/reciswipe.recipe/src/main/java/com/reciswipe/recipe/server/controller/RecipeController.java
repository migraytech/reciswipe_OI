package com.reciswipe.recipe.server.controller;

import com.reciswipe.recipe.IntegrationTesting.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(name = "recipe")
@RestController
public class RecipeController {

    @Autowired
    public RecipeService recipeService;

   //TODO
   // create endsPoints for this service get the all recipes,  update recipe, delete recipes and create recipes.


    //TODO
    // RabbitMQ opzetten met de auth op het moment wanneer de user is ingelogd.


    //TODO
    // Create new class or microservice that contains his favorite recipes.
}
