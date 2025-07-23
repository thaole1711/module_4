package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    @Autowired
    private ICategoryService categoryService;


    @GetMapping("")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(defaultValue = "title") String sortField,
                        @RequestParam(defaultValue = "asc") String sortDir){
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        int size = 5;
        Page<Blog> blogs = blogService.findAll(PageRequest.of(page, size,sort));
        model.addAttribute("blogs", blogs);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("categories", categoryService.findCategory());
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findCategory());
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
            model.addAttribute("categories", categoryService.findCategory());
            return "update";
        }
        attributes.addFlashAttribute("mess", "không tìm thấy blog cần thay đổi");
        return "redirect:/blogs";

    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes attributes) {
        boolean issuccess = blogService.edit(blog);
        if (issuccess) {
            attributes.addFlashAttribute("mess", "cập nhật thành công");
            return "redirect:/blogs";
        } else {
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
    public String search(@RequestParam(name = "page", defaultValue = "0") int page
                         ,@RequestParam(defaultValue = "") String keyword,
                         @RequestParam(required = false) Integer categoryId, Model model
    ) {
        int size = 1;
        int searchId ;
        if(categoryId==null){
            searchId=0;
        }else {
            searchId=categoryId;
        }
        Page<Blog> blogs = blogService.search(keyword,searchId,PageRequest.of(page, size));
        model.addAttribute("blogs", blogs);
        model.addAttribute("keyword", keyword);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("categories", categoryService.findCategory());
        return "index";
    }

}
