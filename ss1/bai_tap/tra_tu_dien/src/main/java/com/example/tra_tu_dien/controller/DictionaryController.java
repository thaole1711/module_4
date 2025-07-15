package com.example.tra_tu_dien.controller;

import com.example.tra_tu_dien.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
   @Autowired
   private IDictionaryService iDictionaryService;

    @GetMapping
    public String lookupDictionary() {
        return "form";
    }

    @PostMapping
    String lookupDictionary(@RequestParam("word") String word,
                            Model model) {
        String result = iDictionaryService.lookupDictionary(word.toLowerCase());
        model.addAttribute("word", word);
        model.addAttribute("result", result != null ? result : "không tìm thấy từ");
        return "form";
}
}
