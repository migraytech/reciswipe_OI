package com.reciswipe.recipe.interfaces;

import com.reciswipe.recipe.server.domain.Recipe;

public interface IValidator {

    boolean  validRecipe(Recipe recipe);
}
