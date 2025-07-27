package com.example.muon_sach.repository;

import com.example.muon_sach.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,String> {
    Book findTopByOrderByBookIdDesc();
}
