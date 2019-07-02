package com.weilyu.springframework.controllers;


import com.weilyu.springframework.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    private final RecipeService recipeService;

    public indexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        //the model can supply attributes used for rendering views.
        model.addAttribute("recipes", recipeService.getRecipes()); // "recipes" here corresponds to the "recipes" in index.html
        return "index"; //index here corresponds to "index.html"
    }
}
