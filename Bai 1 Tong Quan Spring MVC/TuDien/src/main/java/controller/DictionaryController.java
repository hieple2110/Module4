package controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

   DictionaryService dictionaryService;

    @Autowired
    public void setDictionaryService(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/formSearch")
    public String formDictionary() {
        return "dictionary";
    }

    @PostMapping("/dictionary")
    public String dictionary(@RequestParam String name, Model model) {
        String result = dictionaryService.getKey(name);
        if (result != null){
            model.addAttribute("name", name);
            model.addAttribute("result", result);
            model.addAttribute("message", "Search Success");
        }else {
            model.addAttribute("message", "Not found");
        }
        return "show";
    }
}
