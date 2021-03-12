package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String showCalculator() {
        return "form";
    }

    @PostMapping("/calculator")
    public String doCalculator(@RequestParam String first, String second, char calculation, Model model) {
        double a = Double.parseDouble(first);
        double b = Double.parseDouble(second);
        double result = 0;
        String mess = "";
        switch (calculation) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b ==0){
                    mess = "khong the chia cho 0";
                }else {
                    result = a/b;
                }
                break;
        }
        model.addAttribute("a", a);
        model.addAttribute("calculator", calculation);
        model.addAttribute("b", b);
        model.addAttribute("result", result);
        model.addAttribute("mess", mess);
        return "result";
    }
}
