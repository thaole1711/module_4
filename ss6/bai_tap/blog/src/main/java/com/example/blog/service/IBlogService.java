package com.example.blog.service;

import com.example.blog.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(Integer id);
    void add(Blog blog);
    void edit(Blog bog);
    boolean delete(Integer id);
     List<Blog> findAllByTitleContaining(String name);
}
