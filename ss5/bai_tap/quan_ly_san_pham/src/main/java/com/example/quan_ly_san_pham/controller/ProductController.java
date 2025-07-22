package com.example.quan_ly_san_pham.controller;

import com.example.quan_ly_san_pham.entity.Product;
import com.example.quan_ly_san_pham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product, RedirectAttributes attributes) {
        productService.create(product);
        attributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/products";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model, RedirectAttributes attributes) {
        Product product = productService.findById(id);
        if (product == null) {
            attributes.addFlashAttribute("mess", "không tìm thấy sản phẩm");
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "update";

    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes attributes) {
        boolean isSuccess = productService.update(product);
        if (isSuccess) {
            attributes.addFlashAttribute("mess", "cập nhật thành công");
        } else {
            attributes.addFlashAttribute("mess", "cập nhật thất bại");
        }
        return "redirect:/products";
    }

    @PostMapping("{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes attributes) {
        boolean isSuccess = productService.delete(id);
        if (isSuccess) {
            attributes.addFlashAttribute("mess", "xóa thành công");
        } else {
            attributes.addFlashAttribute("mess", "xóa thất bại");
        }
        return "redirect:/products";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        List<Product> products = productService.search(keyword);
            model.addAttribute("keyword", keyword);
            model.addAttribute("products", products);
        return "index";

    }
}
