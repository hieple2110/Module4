package com.codegym.controller;

import com.codegym.model.Form;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class FormController {

    @GetMapping("/form")
    public ModelAndView form(){
        ModelAndView mav  = new ModelAndView("form");
        mav.addObject("form", new Form());
        return mav;
    }

    @PostMapping("/validationForm")
    public String validationForm(@Valid @ModelAttribute(value = "form") Form form, BindingResult bindingResult, Model model){
        new Form().validate(form, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "form";
        }else {
            model.addAttribute("form", form);
            return "result";
        }
    }
}
