package com.reciswipe.recipe.interfaces;

import com.reciswipe.recipe.server.domain.Recipe;

import java.util.List;

public interface IRecipeService extends IGenericService<Recipe> {

    @Override
    Recipe create(Recipe object);

    @Override
    List<Recipe> read();

    @Override
    Recipe update(Recipe object);

    @Override
    boolean delete(Recipe object);
}
