package com.example.quan_ly_san_pham.service;

import com.example.quan_ly_san_pham.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
     void create( Product product);
    public Product findById(int id);
    public boolean update( Product productUpdate);
    public boolean delete(int id);
    public List<Product> search(String name);
}
