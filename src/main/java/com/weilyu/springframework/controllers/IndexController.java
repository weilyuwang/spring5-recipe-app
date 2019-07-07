package com.weilyu.springframework.controllers;


import com.weilyu.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("Getting index page");
        //the model can supply attributes used for rendering views.
        model.addAttribute("recipes", recipeService.getRecipes()); // "recipes" here corresponds to the "recipes" in index.html
        return "index"; //index here corresponds to "index.html"
    }
}
