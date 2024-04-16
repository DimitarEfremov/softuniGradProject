package com.mintleaf.controler;

import com.mintleaf.model.DTOs.CreateRecipeDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RecipeController {

    @GetMapping("/recipe")
    public ModelAndView showRecipe(){

        return new ModelAndView("recipe");
    }

    @GetMapping("/add-recipe")
    public ModelAndView addRecipe(){

        return new ModelAndView("add-recipe");
    }

    @PostMapping("/add-recipe")
    public ModelAndView addRecipe(
            @ModelAttribute("CreateRecipesDTO") @Valid CreateRecipeDTO CreateRecipeDTO, BindingResult bindingResult) {


        if (1==1){
            return new ModelAndView("add-recipe");
        }

        return new ModelAndView("add-recipe");
    }

}
