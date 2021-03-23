package com.codegym.controller;

import com.codegym.model.PhoneNumber;
import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PhoneNumberController {

    @GetMapping("/formNumber")
    public ModelAndView show(){
        ModelAndView mav = new ModelAndView("formNumber");
        mav.addObject("number", new PhoneNumber());
        return mav;
    }

    @PostMapping("/validationNumber")
    public String checkValidation (@Valid @ModelAttribute("number")PhoneNumber phoneNumber, BindingResult bindingResult, Model model){
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "formNumber";
        }
        else {
            model.addAttribute("number", phoneNumber);
            return "result";
        }
    }
}
