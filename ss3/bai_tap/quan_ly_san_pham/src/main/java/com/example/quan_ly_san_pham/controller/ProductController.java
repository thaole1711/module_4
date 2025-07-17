package com.example.quan_ly_san_pham.controller;

import com.example.quan_ly_san_pham.model.Product;
import com.example.quan_ly_san_pham.service.IProductService;
import com.example.quan_ly_san_pham.service.ProductService;
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
    private IProductService iProductService;

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = iProductService.findAll();
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
        product.setId((int) (Math.random() * 10000));
        iProductService.create(product);
        attributes.addFlashAttribute("mess", "them moi thanh cong");
        return "redirect:/products";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model, RedirectAttributes attributes) {
        Product product = iProductService.findById(id);
        if (product == null) {
            attributes.addFlashAttribute("mess", "khong tim thay san pham");
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "update";

    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes attributes) {
        boolean isSuccess = iProductService.update(product);
        if (isSuccess) {
            attributes.addFlashAttribute("mess", "cap nhat thanh cong");
        } else {
            attributes.addFlashAttribute("mess", "cap nhat that bai");
        }
        return "redirect:/products";
    }

    @PostMapping("{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes attributes) {
        boolean isSuccess = iProductService.delete(id);
        if (isSuccess) {
            attributes.addFlashAttribute("mess", "xoa thanh cong");
        } else {
            attributes.addFlashAttribute("mess", "xoa that bai");
        }
        return "redirect:/products";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model){
        List<Product> products=iProductService.search(keyword);
        model.addAttribute("keyword",keyword);
        model.addAttribute("products", products);
        return "index";
    }
}
