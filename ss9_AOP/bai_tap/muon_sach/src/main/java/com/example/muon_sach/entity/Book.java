package com.example.muon_sach.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book extends Parent {
    @Id
    private String bookId;
    private String title;
    private String author;
    private String category;
    private int quantity;



}
