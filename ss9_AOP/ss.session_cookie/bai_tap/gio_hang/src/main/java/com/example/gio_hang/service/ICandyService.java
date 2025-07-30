package com.example.gio_hang.service;

import com.example.gio_hang.entity.Candy;

import java.util.Optional;

public interface ICandyService {
    Iterable<Candy> findAll();
    Optional<Candy> findById(Long id);
}
