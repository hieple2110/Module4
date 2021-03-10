package com.codegym.controller;


import com.codegym.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormCustomer {

    @GetMapping("/addcustomer")
    public String addCustomer(Model model, Customer customer){
        model.addAttribute("customer", customer);
        return "add";
    }

@PostMapping("/add")
    public String add(@ModelAttribute Customer customer, ModelMap modelMap){
        modelMap.addAttribute("thang", customer);

}
}
