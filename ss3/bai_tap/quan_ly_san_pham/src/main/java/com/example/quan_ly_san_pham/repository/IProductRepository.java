package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void create( Product product);
    public Product findById(int id);
    public boolean update( Product productUpdate);
    public boolean delete(int id);
    public List<Product> search(String name);
}
