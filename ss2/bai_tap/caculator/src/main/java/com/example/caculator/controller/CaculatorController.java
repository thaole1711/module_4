package com.example.caculator.controller;

import com.example.caculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @Autowired
    private ICalculatorService iCalculatorService;
    @GetMapping("/")
    public String calculate() {
        return "calculator";
    }
    @PostMapping("/calculator")
    public String calculate(@RequestParam String first, String second, String operator, Model model){
        try{
            double result= iCalculatorService.calculate(first,second,operator);
            model.addAttribute("result", result);
        }catch (ArithmeticException e){
            model.addAttribute("error","không thể chia cho 0");
        }catch ( NumberFormatException e){
            model.addAttribute("error", "vui lòng nhập toán hạng giá trị kiểu số");
        }catch(IllegalArgumentException e){
            model.addAttribute("error", "vui lòng chọn phép toán hợp lệ");
        }
        model.addAttribute("first", first);
        model.addAttribute("second", second);
        model.addAttribute("operator", operator);
        return "calculator";

    }
}
