package com.example.quan_ly_danh_sach_khach_hang.repository;

import com.example.quan_ly_danh_sach_khach_hang.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1, "HaiTT", "le12@gmail.com", "Da Nang"));
        customers.add(new Customer(2, "Ddong", "le12@gmail.com", "Da Nang"));
        customers.add(new Customer(3, "Thao", "le12@gmail.com", "Da Nang"));
        customers.add(new Customer(4, "Ha", "le12@gmail.com", "Da Nang"));
    }

    public List<Customer> findAll() {
        return customers;
    }

}
