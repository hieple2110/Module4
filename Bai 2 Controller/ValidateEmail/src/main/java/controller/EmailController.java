package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailController {
    private static Pattern pattern;
    private Matcher matcher;

    public boolean validate(String email) {
        String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @GetMapping("/form")
    public String getIndex() {
        return "index";
    }

    @PostMapping("/validate")
    public String validateEmail(@RequestParam("email") String email, Model model) {
        boolean isValidate = this.validate(email);
        if (isValidate) {
            model.addAttribute("email", email);
            return "success";
        } else {
            model.addAttribute("message", "email not validate.");
            return "index";
        }
    }
}
