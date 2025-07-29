package com.example.muon_sach.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "borrow_code")
@Setter
@Getter
public class BorrowCode extends Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBorrowCode;
    private String borrowCode;
    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;
}
