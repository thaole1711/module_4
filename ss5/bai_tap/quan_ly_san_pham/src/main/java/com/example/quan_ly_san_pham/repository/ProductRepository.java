package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {


    @Override
    public List<Product> findAll() {
        List<Product> productList = BaseRepository.entityManager.createQuery("select p from Product p").getResultList();
        return productList;
    }

    @Override
    public void create(Product product) {
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();

    }

    @Override
    public Product findById(int id) {
        Product product = BaseRepository.entityManager.find(Product.class, id);
        return product;
    }
    @Override
    public boolean update(Product productUpdate) {
        Product product = findById(productUpdate.getId());
        if (product == null) {
            return false;
        }
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(productUpdate);
        entityTransaction.commit();
        return true;
    }

    @Override
    public boolean delete(int id) {
        Product product= findById(id);
        if(product!=null) {
            EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
            entityTransaction.begin();
            BaseRepository.entityManager.remove(product);
            return true;
        }
       return false;
    }

    @Override
    public List<Product> search(String name) {
        EntityTransaction entityTransaction= BaseRepository.entityManager.getTransaction();
     entityTransaction.begin();
        List<Product>  products=BaseRepository.entityManager.createQuery("select p from Product p where p.name like :name",Product.class).setParameter("name","%"+name+"%").getResultList();
         entityTransaction.commit();
        return products;
    }
}
