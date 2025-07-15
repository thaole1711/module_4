package com.example.chuyen_doi_tien_te.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface ICurrencyService {
    Double exchangeMoney( String from, String to,String amount) throws NumberFormatException;
}
