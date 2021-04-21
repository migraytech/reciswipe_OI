package com.reciswipe.recipe.validator;

import com.reciswipe.recipe.interfaces.IValidator;
import com.reciswipe.recipe.server.domain.Recipe;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RecipeValidator implements IValidator {


    @Override
    public boolean validRecipe(Recipe recipe) {
        if(recipe == null && recipe.getName().equals(" ") && recipe.getKitchens() == null)
            return false;
        else
            return true;
    }
}
