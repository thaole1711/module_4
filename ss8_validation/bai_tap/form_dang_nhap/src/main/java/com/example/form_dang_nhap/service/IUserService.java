package com.example.form_dang_nhap.service;

import com.example.form_dang_nhap.entity.User;

public interface IUserService {
    void create(User user);
    User findById(Integer id);
}
