package com.weilyu.springframework.controllers;

import com.weilyu.springframework.commands.RecipeCommand;
import com.weilyu.springframework.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/show";
    }

    @RequestMapping("recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeform";
    }

    @PostMapping("recipe")
    //The method annotated with @PostMapping("recipe") will get called when the recipeform is submitted.

    public String saveOrUpdate(@ModelAttribute RecipeCommand command){

        //@ModelAttribute tells Spring to bind the form post parameters to the RecipeCommand object

        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/show/" + savedCommand.getId();
    }

}
