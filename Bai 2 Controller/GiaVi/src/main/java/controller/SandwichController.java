package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/save")
    public String show(){
        return "show";
    }

    @PostMapping("/save")
    public String save(@RequestParam("condiments") String condiment , Model model){
        model.addAttribute("condiments", condiment);
        return "result";
    }
}
