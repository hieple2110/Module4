package com.controller;

import com.model.Blog;
import com.service.BlogService;
import com.service.BlogServiceIm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogServiceIm blogServiceIm;


    @GetMapping("/blog")
    public ModelAndView show() {
        List<Blog> listBlog = this.blogServiceIm.findAll();
        ModelAndView mav = new ModelAndView("formList");
        mav.addObject("listBlog", listBlog);
        return mav;
    }

    @GetMapping("/createBlog")
    public ModelAndView createBlog() {
        ModelAndView mav = new ModelAndView("formCreate");
        mav.addObject("blog", new Blog());
        return mav;
    }

    @PostMapping("/saveBlog")
    public String saveBlog(Blog blog, RedirectAttributes redirect) {
        if (blog.getTitle().trim().length() == 0 || blog.getTitle().trim().length() == 0) {
            redirect.addFlashAttribute("message", "Save blog fail");
        } else {
            this.blogServiceIm.save(blog);
            redirect.addFlashAttribute("message", "Save Blog successfully");
        }
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editBlog(@PathVariable(value = "id") int id) {
        ModelAndView mav = new ModelAndView("formEdit");
        mav.addObject("blog", this.blogServiceIm.findById(id));
        return mav;
    }

    @PostMapping("/editBlog")
    public String eidt(Blog blog, RedirectAttributes redirect) {
        this.blogServiceIm.save(blog);
        redirect.addFlashAttribute("message", "Update Blog successfully");
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteBlog(@PathVariable(value = "id") int id) {
        ModelAndView mav = new ModelAndView("formDelete");
        mav.addObject("blog", this.blogServiceIm.findById(id));
        return mav;
    }

    @PostMapping("/deleteBlog")
    public String delete(Blog blog, RedirectAttributes redirect) {
        this.blogServiceIm.remove(blog.getId());
        redirect.addFlashAttribute("message", "Delete Blog successfully");
        return "redirect:/blog";
    }
}
