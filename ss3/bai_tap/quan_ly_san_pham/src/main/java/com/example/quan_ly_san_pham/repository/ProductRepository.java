package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Laptop Dell XPS 13", 29999.99, "Ultrabook nhỏ gọn, mạnh mẽ", "Dell"));
        products.add(new Product(2, "iPhone 15 Pro", 33999.00, "Điện thoại thông minh cao cấp", "Apple"));
        products.add(new Product(3, "Samsung Galaxy S24", 27999.50, "Smartphone Android hiệu năng cao", "Samsung"));
        products.add(new Product(4, "Sony WH-1000XM5", 7999.00, "Tai nghe chống ồn chất lượng cao", "Sony"));
        products.add(new Product(5, "MacBook Air M2", 28999.00, "Laptop siêu nhẹ, pin lâu", "Apple"));
        products.add(new Product(6, "Asus ROG Strix G16", 35999.99, "Laptop gaming cấu hình khủng", "Asus"));
        products.add(new Product(7, "Xiaomi Mi Band 8", 999.00, "Vòng đeo tay thông minh, giá rẻ", "Xiaomi"));
    }
@Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void create(Product product) {
        products.add(product);
    }
    @Override
    public Product findById(int id) {
        for (Product product: products){
            if(product.getId()==id){
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean update( Product productUpdate) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == productUpdate.getId()) {
                products.set(i, productUpdate);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                products.remove(i);
                return true;
            }
        }
        return false;
    }
    @Override
    public List<Product> search(String name){
        List<Product> productList= new ArrayList<>();
        for(Product product : products){
            if(product.getName().contains(name)){
                productList.add(product);
            }
        }
        return productList;
    }
}
