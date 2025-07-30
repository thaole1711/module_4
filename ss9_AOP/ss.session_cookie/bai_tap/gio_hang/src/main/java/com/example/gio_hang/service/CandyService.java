package com.example.gio_hang.service;

import com.example.gio_hang.entity.Candy;
import com.example.gio_hang.repository.ICandyRepo;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CandyService implements ICandyService {
    private final ICandyRepo iCandyRepo;

    public CandyService(ICandyRepo iCandyRepo) {
        this.iCandyRepo = iCandyRepo;
    }


    @Override
    public Iterable<Candy> findAll() {
        return iCandyRepo.findAll();
    }

    @Override
    public Optional<Candy> findById(Long id) {
        return iCandyRepo.findById(id);
    }
}
