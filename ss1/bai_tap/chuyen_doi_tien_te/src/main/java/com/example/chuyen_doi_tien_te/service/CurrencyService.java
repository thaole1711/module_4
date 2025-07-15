package com.example.chuyen_doi_tien_te.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
@Service
public class CurrencyService implements ICurrencyService{

    @Override
    public Double exchangeMoney(String from, String to, String amount) throws NumberFormatException{
        try{
           double parsedAmount=Double.parseDouble(amount);
            double result;
            if (from.equals("USD") && to.equals("VND")) {
                result = parsedAmount * 20000;
            } else if (from.equals("VND") && to.equals("USD")) {
                result = parsedAmount / 20000;
            } else {
                result = parsedAmount;
            }
            return result;
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }


    }
}
