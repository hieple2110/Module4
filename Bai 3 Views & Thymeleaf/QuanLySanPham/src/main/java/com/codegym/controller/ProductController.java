package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/listProduct")
    public ModelAndView showList(){
        ModelAndView mav = new ModelAndView("listProduct");
        List<Product> listProduct = this.productService.getAll();
        mav.addObject("listProduct", listProduct);
        return mav;
    }

    @GetMapping("/product/create")
    public ModelAndView formCreate(){
        ModelAndView mav = new ModelAndView("createProduct");
        mav.addObject("product", new Product());
        return mav;
    }

    @PostMapping("/product/save")
    public String save(Product product, RedirectAttributes redirectAttributes){
        product.setId((int)(Math.random()*100));
        this.productService.add(product);
        redirectAttributes.addFlashAttribute("success", "Create product successfully");
        return "redirect:/listProduct";
    }

    @GetMapping("/product/{id}/edit")
    public ModelAndView formEdit(@PathVariable(value = "id") int id){
        ModelAndView mav = new ModelAndView("editProduct");
        mav.addObject("product",this.productService.findById(id));
        return mav;
    }

    @PostMapping("/product/edit")
    public String edit(Product product, RedirectAttributes redirectAttributes){
        this.productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("success", "Edit product successfully");
        return "redirect:/listProduct";
    }

    @GetMapping("/product/{id}/delete")
    public ModelAndView formDelete(@PathVariable(value = "id") int id){
        ModelAndView mav = new ModelAndView("deleteProduct");
        mav.addObject("product",this.productService.findById(id));
        return mav;
    }

    @PostMapping("/product/delete")
    public String delete(Product product ,RedirectAttributes redirectAttributes){
        this.productService.delete(product.getId());
        redirectAttributes.addFlashAttribute("success", "Delete product successfully");
        return "redirect:/listProduct";
    }
}
