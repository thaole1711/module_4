package com.example.gio_hang.repository;

import com.example.gio_hang.entity.Candy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICandyRepo extends JpaRepository<Candy,Long> {
}
