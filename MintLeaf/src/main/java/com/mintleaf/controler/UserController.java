package com.mintleaf.controler;

import com.mintleaf.model.DTOs.CreateUserDTO;
import com.mintleaf.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login(){

        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView register(){

        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(
            @ModelAttribute("CreateUserDTO") @Valid CreateUserDTO createUserDTO, BindingResult bindingResult){

        boolean hasSuccessfulRegistration = userService.registerUser(createUserDTO);

        if (hasSuccessfulRegistration){
            return new ModelAndView("login");
        }
        return new ModelAndView("register");
    }


}
