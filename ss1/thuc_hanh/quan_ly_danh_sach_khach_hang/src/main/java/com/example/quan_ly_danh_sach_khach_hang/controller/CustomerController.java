package com.example.quan_ly_danh_sach_khach_hang.controller;

import com.example.quan_ly_danh_sach_khach_hang.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {
@Autowired
private ICustomerService iCustomerService;
  @GetMapping
    public String showList(Model model){
      model.addAttribute("customers", iCustomerService.findAll());
        return "list";
    }
}
