package com.hiep.controller;

import com.hiep.model.Customer;
import com.hiep.service.CustomerService;
import com.hiep.service.ICustomerService;
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
    private ICustomerService iCustomerService;

    @GetMapping("/customer")
    public ModelAndView show() {
        List<Customer> listCustomer = this.iCustomerService.findAll();
        ModelAndView mav = new ModelAndView("listCustomer");
        mav.addObject("listCustomer", listCustomer);
        return mav;
    }

    @GetMapping("/create")
    public ModelAndView formCreate(){
        ModelAndView mav = new ModelAndView("create");
        mav.addObject("customer", new Customer());
        return mav;
    }

    @PostMapping("/save")
    public String create(Customer customer, RedirectAttributes redirect){
        this.iCustomerService.save(customer);
        redirect.addFlashAttribute("message", "Create Customer successfully");
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView formEdit(@PathVariable(value = "id") int id){
        Customer customer = this.iCustomerService.findById(id);
        ModelAndView mav = new ModelAndView("edit");
        mav.addObject("customer", customer);
        return mav;
    }

    @PostMapping("/edit")
    public String edit(Customer customer, RedirectAttributes redirect){
        this.iCustomerService.save(customer);
        redirect.addFlashAttribute("message", "Edit Customer successfully");
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView formDelete(@PathVariable(value = "id") int id){
        Customer customer = this.iCustomerService.findById(id);
        ModelAndView mav = new ModelAndView("delete");
        mav.addObject("customer", customer);
        return mav;
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect){
        this.iCustomerService.remove(customer.getId());
        redirect.addFlashAttribute("message", "Delete Customer successfully");
        return "redirect:/customer";
    }

    @GetMapping("/view/{id}")
    public ModelAndView formView(@PathVariable(value = "id") int id){
        Customer customer = this.iCustomerService.findById(id);
        ModelAndView mav = new ModelAndView("view");
        mav.addObject("customer", customer);
        return mav;
    }
}
