package com.codegym.controller;

import com.codegym.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("showForm")
    public ModelAndView show(){
        ModelAndView mav = new ModelAndView("form");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/validationUser")
    public ModelAndView validate(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            ModelAndView mav = new ModelAndView("form");
            return mav;
        }else {
            ModelAndView modelAndView = new ModelAndView("result");
            return modelAndView;
        }
    }
}
