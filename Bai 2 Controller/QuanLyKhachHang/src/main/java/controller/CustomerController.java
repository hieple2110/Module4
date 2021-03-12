package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.CustomerService;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public ModelAndView getList() {
        ModelAndView mav = new ModelAndView("list");
        List<Customer> list = this.customerService.getAll();
        mav.addObject("list", list);
        return mav;
    }

    @GetMapping("/saveCustomer")
    public ModelAndView formSave() {
        ModelAndView mav = new ModelAndView("formSave");
        mav.addObject("customer", new Customer());
        return mav;
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        this.customerService.add(customer);
        return "redirect:/list";
    }

    @GetMapping("/updateCustomer")
    public ModelAndView formUpdate(@RequestParam(value = "id", defaultValue = "0") int id) {
        ModelAndView mav = new ModelAndView("formUpdate");
        Customer customer = this.customerService.findById(id);
        mav.addObject("customer", customer);
        return mav;
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute("customer") Customer customer) {
        boolean result = this.customerService.edit(customer);
        if (result){
            return "redirect:/list";
        }else {
            return "formUpdate";
        }
    }

    @GetMapping("/deleteCustomer")
    public String formDelete(@RequestParam(value = "id", defaultValue = "0") int id){
        Customer customer = this.customerService.findById(id);
        this.customerService.delete(customer);
        return "redirect:/list";
    }

}
