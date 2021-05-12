package com.reciswipe.recipe.repository;


import com.reciswipe.recipe.server.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long> {

    @Override
    List<Recipe> findAll();

}
