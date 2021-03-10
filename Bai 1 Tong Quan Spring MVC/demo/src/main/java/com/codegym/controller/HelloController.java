package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/hello")
public class HelloController {
//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(value = "name", defaultValue = "") String name, Model model){
//        model.addAttribute("name" ,name);
//        return "greeting";
//    }

//    @GetMapping("/greeting/{name}")
//    public String greet(@PathVariable(value = "name") String name, Model model){
//        model.addAttribute("name" ,name);
//        return "greeting";
//    }

    @GetMapping("/greeting/{name}")
    public String gree(@PathVariable() Optional<Integer> name, Model model){
        if (name.isPresent()){
            model.addAttribute("name" ,name.get());
            return "greeting";
        }else {
            model.addAttribute("name" ,0);
            return "greeting";
        }

    }

}

