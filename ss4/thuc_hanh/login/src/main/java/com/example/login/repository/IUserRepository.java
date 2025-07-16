package com.example.login.repository;

import com.example.login.module.Login;
import com.example.login.module.User;

public interface IUserRepository {
    User checkLogin(Login login);
}
