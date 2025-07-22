package com.example.blog.service;

import com.example.blog.entity.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void add(Blog blog) {
        if (blog.getId() == null || findById(blog.getId()) == null) {
            blogRepository.save(blog);
        }

    }

    @Override
    public void edit(Blog bog) {
        if (findById(bog.getId()) != null) {
            bog.setId(bog.getId());
            blogRepository.save(bog);
        }
    }

    @Override
    public boolean delete(Integer id) {
        Blog blog = findById(id);
        if (blog != null) {
            blogRepository.delete(blog);
            return true;
        }
        return false;

    }
    @Override
   public List<Blog> findAllByTitleContaining(String name){
      return   blogRepository.findAllByTitleContaining(name);

    }


}
