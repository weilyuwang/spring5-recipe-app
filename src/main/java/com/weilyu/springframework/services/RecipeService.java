package com.weilyu.springframework.services;

import com.weilyu.springframework.commands.RecipeCommand;
import com.weilyu.springframework.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}

