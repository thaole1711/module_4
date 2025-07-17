package com.example.product_slack.controller;

import com.example.product_slack.model.Customer;
import com.example.product_slack.repository.ICustomerRepository;
import com.example.product_slack.service.CustomerService;
import com.example.product_slack.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final ICustomerService iCustomerService = new CustomerService();

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customers = iCustomerService.findAll();
        model.addAttribute("customers", customers);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/save")
    public String save(Customer customers, Model model) {
        customers.setId((int) (Math.random() * 10000));
        iCustomerService.save(customers);
        model.addAttribute("customers", customers);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String edit(Customer customer) {
        iCustomerService.update(customer.getId(), customer);
        return "redirect:/customers";

    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        iCustomerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customers";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "view";
    }
}
