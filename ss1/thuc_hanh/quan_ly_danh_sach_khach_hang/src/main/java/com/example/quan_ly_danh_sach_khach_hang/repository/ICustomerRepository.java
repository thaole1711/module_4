package com.example.quan_ly_danh_sach_khach_hang.repository;

import com.example.quan_ly_danh_sach_khach_hang.entity.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
}
