package com.example.form_dang_nhap.repository;

import com.example.form_dang_nhap.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface IUserRepository extends JpaRepository<User,Integer> {
    User findByBirthDay(LocalDate birthDay);
}
