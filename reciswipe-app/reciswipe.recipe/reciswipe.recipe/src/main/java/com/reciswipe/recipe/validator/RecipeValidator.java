package com.reciswipe.recipe.validator;

import com.reciswipe.recipe.interfaces.IValidator;
import com.reciswipe.recipe.server.domain.Recipe;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RecipeValidator implements IValidator {


    @Override
    public boolean validRecipe(Recipe recipe) {
        return recipe != null || !recipe.getName().isEmpty() || recipe.getKitchens() != null;
    }
}
