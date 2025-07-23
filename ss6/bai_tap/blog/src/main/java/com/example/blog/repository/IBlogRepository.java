package com.example.blog.repository;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    List<Blog> findAllByTitleContaining(String name , Integer idCategory);

    @Query("SELECT b FROM Blog b WHERE (b.category.idCategory = :idCategory OR :idCategory = 0) AND (b.title LIKE CONCAT('%', :name, '%'))")
    Page<Blog> search(@Param("name") String name,
                      @Param("idCategory") Integer idCategory,
                      Pageable pageable);

}

//b.title=:name or

