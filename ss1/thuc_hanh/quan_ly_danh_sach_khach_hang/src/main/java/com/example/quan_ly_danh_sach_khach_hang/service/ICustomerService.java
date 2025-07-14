package com.example.quan_ly_danh_sach_khach_hang.service;

import com.example.quan_ly_danh_sach_khach_hang.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
}
