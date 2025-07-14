package com.example.tra_tu_dien;

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
    private static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("dictionary", "từ điển");
        dictionary.put("look", "nhìn");
        dictionary.put("cat", "con mèo");
        dictionary.put("good", "tốt");
        dictionary.put("bad", "xấu");
    }

    @GetMapping
    public String lookupDictionary() {
        return "form";
    }

    @PostMapping
    String lookupDictionary(@RequestParam("word") String word,
                            Model model) {
        String result = dictionary.get(word.toLowerCase());
        model.addAttribute("word", word);
        model.addAttribute("result", result != null ? result : "không tìm thấy từ");
        return "form";
}
}
