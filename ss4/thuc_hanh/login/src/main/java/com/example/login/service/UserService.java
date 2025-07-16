package com.example.login.service;

import com.example.login.module.Login;
import com.example.login.module.User;
import com.example.login.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public User checkLogin(Login login) {
        return iUserRepository.checkLogin(login);
    }
}
