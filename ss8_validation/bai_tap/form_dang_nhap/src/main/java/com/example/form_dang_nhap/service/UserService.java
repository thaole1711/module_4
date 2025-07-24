package com.example.form_dang_nhap.service;

import com.example.form_dang_nhap.entity.User;
import com.example.form_dang_nhap.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;
    @Override
    public void create(User user) {
        userRepository.save(user);
    }
}
