package com.example.login.service;

import com.example.login.module.Login;
import com.example.login.module.User;

public interface IUserService {
    User checkLogin(Login login);

}
