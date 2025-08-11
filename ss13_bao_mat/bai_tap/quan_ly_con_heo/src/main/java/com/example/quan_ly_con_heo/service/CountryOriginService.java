package com.example.quan_ly_con_heo.service;

import com.example.quan_ly_con_heo.entity.CountryOrigin;
import com.example.quan_ly_con_heo.repository.ICountryOriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryOriginService implements ICountryOriginService{
    @Autowired
    private ICountryOriginRepository countryOriginRepository;

    @Override
    public List<CountryOrigin> findAll() {
        return countryOriginRepository.findAll();
    }
}
