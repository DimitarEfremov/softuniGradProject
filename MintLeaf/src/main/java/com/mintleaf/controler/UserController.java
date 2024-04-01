package com.mintleaf.controler;

import com.mintleaf.model.DTOs.CreateUserDTO;
import com.mintleaf.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public ModelAndView login() {

        return new ModelAndView("login");
    }

    @PostMapping("/login-error")
    public String loginError(@ModelAttribute("username") String username, Model model) {

        model.addAttribute("username", username);
        model.addAttribute("bad_credentials", "true");

        return "login";
    }


    @GetMapping("/register")
    public ModelAndView register(
            @ModelAttribute("createUserDTO") CreateUserDTO createUserDTO
    ) {

        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(
            @ModelAttribute("createUserDTO") @Valid CreateUserDTO createUserDTO, BindingResult bindingResult) {

        boolean hasSuccessfulRegistration = userService.registerUser(createUserDTO);

        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");
        }

        if (!hasSuccessfulRegistration) {
            ModelAndView modelAndView = new ModelAndView("register");
            modelAndView.addObject("hasRegistrationError", true);
            return modelAndView;
        }

        return new ModelAndView("login");
    }


}
