package com.mintleaf.controler;

import com.mintleaf.model.DTOs.CreateRecipeDTO;
import com.mintleaf.model.entities.User;
import com.mintleaf.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RecipeController {

    private final UserService userService;

    public RecipeController(UserService userService) {
        this.userService = userService;
    }

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
            @ModelAttribute("CreateRecipeDTO") @Valid CreateRecipeDTO createRecipeDTO, BindingResult bindingResult) {

        User currentUser = getCurrentUser(userService);

        createRecipeDTO.setCreatedBy(currentUser);

        return new ModelAndView("add-recipe");
    }

    private static User getCurrentUser(UserService userService) {
        String currentUserName = "";

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)){
            currentUserName = authentication.getName();
        }

        return userService.getUserByName(currentUserName);
    }

}
