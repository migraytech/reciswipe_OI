package com.reciswipe.recipe.validator;

import com.reciswipe.recipe.interfaces.IValidator;
import com.reciswipe.recipe.server.domain.Recipe;

public class RecipeValidator implements IValidator {


    @Override
    public boolean validRecipe(Recipe recipe) {
        return false;
    }
}
