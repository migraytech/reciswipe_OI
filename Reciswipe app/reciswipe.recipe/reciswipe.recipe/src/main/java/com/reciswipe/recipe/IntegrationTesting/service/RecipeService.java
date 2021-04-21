package com.reciswipe.recipe.IntegrationTesting.service;

import com.reciswipe.recipe.interfaces.IRecipeService;
import com.reciswipe.recipe.interfaces.IValidator;
import com.reciswipe.recipe.server.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService implements IRecipeService {

    @Override
    public Recipe create(Recipe object) {

        return null;
    }

    @Override
    public List<Recipe> read() {
        return null;
    }

    @Override
    public Recipe update(Recipe object) {
        return null;
    }

    @Override
    public boolean delete(Recipe object) {
        return false;
    }

 
}
