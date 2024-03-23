package com.mintleaf.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AllRecipesController {

    @GetMapping("/allRecipes")
    public ModelAndView allRecipes(){

        return new ModelAndView("allRecipes");
    }

}
