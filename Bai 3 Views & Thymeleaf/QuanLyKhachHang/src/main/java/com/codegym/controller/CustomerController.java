package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/listCustomer")
    public ModelAndView showList(){
        ModelAndView mav = new ModelAndView("listCustomer");
        List<Customer> listCustomer = this.customerService.getAll();
        mav.addObject("listCustomer", listCustomer);
        return mav;
    }

    @GetMapping("/customer/create")
    public ModelAndView create(){
        ModelAndView mav = new ModelAndView("createCustomer");
        mav.addObject("customer", new Customer());
        return mav;
    }

    @PostMapping("/customer/save")
    public String save(Customer customer, RedirectAttributes redirect){
        customer.setId((int)(Math.random()*100));
        this.customerService.add(customer);
        redirect.addFlashAttribute("success", "Add customer success");
        return "redirect:/listCustomer";
    }

    @GetMapping("/customer/{id}/edit")
    public ModelAndView formEdit(@PathVariable(value = "id") int id){
        ModelAndView mav = new ModelAndView("editCustomer");
        mav.addObject("customer", this.customerService.findById(id));
        return mav;
    }

    @PostMapping("/customer/edit")
    public String edit(Customer customer, RedirectAttributes redirect){
        this.customerService.update(customer.getId(),customer);
        redirect.addFlashAttribute("success", "update customer success");
        return "redirect:/listCustomer";
    }

    @GetMapping("/customer/{id}/delete")
    public ModelAndView formDelete(@PathVariable int id){
        ModelAndView mav = new ModelAndView("deleteCustomer");
        mav.addObject("customer", this.customerService.findById(id));
        return mav;
    }

    @PostMapping("/customer/delete")
    public String delete(Customer customer, RedirectAttributes redirectAttributes){
        this.customerService.delete(customer.getId());
        redirectAttributes.addFlashAttribute("success", "Delete customer successfully");
        return "redirect:/listCustomer";
    }

    @GetMapping("/customer/{id}/view")
    public ModelAndView showInformation(@PathVariable(value = "id") int id){
        ModelAndView mav = new ModelAndView("viewCustomer");
        mav.addObject("customer", this.customerService.findById(id));
        return mav;
    }
}
