package com.example.chuyen_doi_tien_te.controller;

import com.example.chuyen_doi_tien_te.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    private ICurrencyService iCurrencyService;
    @GetMapping
    public String exchangeMoney(){
        return "form";
    }
    @PostMapping
    public String exchangeMoney(@RequestParam("from") String from,
                                @RequestParam("to") String to,
                                @RequestParam String amount,
                                Model model) {
        try{
            double result= iCurrencyService.exchangeMoney(from,to,amount);
            model.addAttribute("result", result);
        } catch (NumberFormatException e) {
            model.addAttribute("error","cần nhập giá trị bằng số");
        }

        return "form";
    }
}
