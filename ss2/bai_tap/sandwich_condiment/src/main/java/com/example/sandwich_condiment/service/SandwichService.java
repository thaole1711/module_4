package com.example.sandwich_condiment.service;

import com.example.sandwich_condiment.repository.ISandwichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SandwichService implements ISandwichService{
    @Autowired
    private ISandwichRepository iSandwichRepository;
    @Override
    public String[] display() {
        return iSandwichRepository.display();
    }
}
