package com.example.string_email.controller;

import jdk.internal.icu.text.NormalizerBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/validate")
public class EmailController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)";
    private static Pattern pattern;
 public EmailController(){
     pattern=Pattern.compile(EMAIL_REGEX);
 }
 private boolean validate(String regex){
     Matcher matcher = pattern.matcher(regex);
     return matcher.matches();
 }
 @GetMapping()
    public String home(){
     return "home";
 }
 @PostMapping()
    public  String user(@RequestParam("email") String email, Model model){
     boolean isValid=validate(email);
     if(!isValid){
         model.addAttribute("message","email is invalid");
         return "home";
     }else {
         model.addAttribute("email",email);
         return "success";
     }
 }


}

