package com.reciswipe.recipe.interfaces;

import com.reciswipe.recipe.server.domain.Recipe;

public interface IValidator {


    ///TODO
    // Create Design pattern to implement on the Entity Recipe
    //https://stackoverflow.com/questions/69079291/combinator-pattern-java-function-e-t


    boolean  validRecipe(Recipe recipe);
}
