package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String index(Model model) {
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs", blogs);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes attributes) {
        blogService.add(blog);
        attributes.addFlashAttribute("mess", "thêm mới thành công");
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            model.addAttribute("blog", blog);
            return "update";
        }
        attributes.addFlashAttribute("mess", "không tìm thấy blog cần thay đổi");
        return "redirect:/blogs";

    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes attributes) {
      boolean issuccess=  blogService.edit(blog);
      if(issuccess){
          attributes.addFlashAttribute("mess", "cập nhật thành công");
          return "redirect:/blogs";
      }else {
          attributes.addFlashAttribute("mess", "cập nhật không thành công");
          return "redirect:/blogs";
      }
        
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes attributes) {
        boolean issuccess = blogService.delete(id);
        if (issuccess) {
            attributes.addFlashAttribute("mess", "xóa thành công");
        } else {
            attributes.addFlashAttribute("mess", "xóa thất bại");

        }
        return "redirect:/blogs";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        List<Blog> blogs = blogService.findAllByTitleContaining(keyword);
        model.addAttribute("blogs", blogs);
        model.addAttribute("keyword", keyword);
        return "index";
    }

}
