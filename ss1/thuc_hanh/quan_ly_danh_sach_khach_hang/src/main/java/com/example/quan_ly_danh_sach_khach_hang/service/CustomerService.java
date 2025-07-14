package com.example.quan_ly_danh_sach_khach_hang.service;

import com.example.quan_ly_danh_sach_khach_hang.entity.Customer;
import com.example.quan_ly_danh_sach_khach_hang.repository.CustomerRepository;
import com.example.quan_ly_danh_sach_khach_hang.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }
}
