package com.example.muon_sach.service;

import com.example.muon_sach.entity.Book;
import com.example.muon_sach.entity.BorrowCode;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(String id);
    void add(Book book);
    void update(Book book);
    String randomBorrowCode();

}
