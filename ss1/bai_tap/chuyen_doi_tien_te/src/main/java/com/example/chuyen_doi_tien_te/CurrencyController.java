package com.example.chuyen_doi_tien_te;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/currency")
public class CurrencyController {
    @GetMapping
    public String exchangeMoney(){
        return "form";
    }
    @PostMapping
    public String exchangeMoney(@RequestParam("from") String from,
                                @RequestParam("to") String to,
                                @RequestParam double amount,
                                Model model) {
        double result;
        if (from.equals("USD") && to.equals("VND")) {
            result = amount * 20000;
        } else if (from.equals("VND") && to.equals("USD")) {
            result = amount / 20000;
        } else {
            result = amount;
        }
        model.addAttribute("result", result);
        return "form";
    }
}
