package com.example.setting.controller;

import com.example.setting.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SettingController {
    @GetMapping("/setting")
    public String setting(Model model) {
        model.addAttribute("setting", new Setting());
        return "create";
    }

    @PostMapping("/save")
    public String save(Model model, @ModelAttribute Setting setting) {
        model.addAttribute("setting", setting);
        return "setting";
    }

}