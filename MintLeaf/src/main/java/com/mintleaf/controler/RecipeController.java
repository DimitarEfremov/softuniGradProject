package com.mintleaf.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RecipeController {

    @GetMapping("/add-recipe")
    public ModelAndView addRecipe(){

        return new ModelAndView("add-recipe");
    }

    @GetMapping("/recipe")
    public ModelAndView showRecipe(){

        return new ModelAndView("recipe");
    }


}
