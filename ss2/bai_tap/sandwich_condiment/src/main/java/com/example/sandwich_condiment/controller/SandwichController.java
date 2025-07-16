package com.example.sandwich_condiment.controller;

import com.example.sandwich_condiment.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class SandwichController {
    @Autowired
    private ISandwichService iSandwichService;
    @GetMapping("/sandwich")
    public String display(Model model){
      String[] sandwichs= iSandwichService.display();
      model.addAttribute("sandwichs",sandwichs);
      return "sandwich" ;

    }
    @PostMapping("/save")
    public String save(@RequestParam (name="condiment",defaultValue = "")String[] condiments, Model model){
        String[] sandwichs= iSandwichService.display();
        model.addAttribute("sandwichs",sandwichs);
        if(condiments==null||condiments.length==0){
            model.addAttribute("mess","Please select your condiments.");
            return "sandwich";
        }
            model.addAttribute("condiments",condiments);
            return "sandwich";




    }
}
