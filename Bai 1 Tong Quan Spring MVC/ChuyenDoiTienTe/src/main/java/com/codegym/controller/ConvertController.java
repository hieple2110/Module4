package com.codegym.controller;

import com.codegym.model.MoneyConverter;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConvertController {
    @GetMapping("/convert")
    public String formConvert(@ModelAttribute("convert") MoneyConverter converter) {
        return "convert";
    }

    @PostMapping("/convert")
    public String convert(@ModelAttribute("convert") MoneyConverter converter) {
        float total = converter.getUsd() * converter.getVnd();
        converter.setTotal(total);
        return "converter";
    }

}
