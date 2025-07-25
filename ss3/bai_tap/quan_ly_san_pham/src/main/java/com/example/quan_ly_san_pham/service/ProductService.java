package com.example.quan_ly_san_pham.service;

import com.example.quan_ly_san_pham.model.Product;
import com.example.quan_ly_san_pham.repository.IProductRepository;
import com.example.quan_ly_san_pham.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void create(Product product) {
        int productId = 0;
        boolean flag = true;
        while (flag) {
            productId = (int) (Math.random() * 10000);
            List<Product> products = findAll();
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId() == productId) {
                    break;
                } else if (i == products.size() - 1) {
                    flag = false;
                }
            }
        }
        product.setId(productId);
        iProductRepository.create(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public boolean update(Product productUpdate) {
        return iProductRepository.update(productUpdate);
    }

    @Override
    public boolean delete(int id) {
        return iProductRepository.delete(id);
    }

    @Override
    public List<Product> search(String name) {
        return iProductRepository.search(name);
    }
}
