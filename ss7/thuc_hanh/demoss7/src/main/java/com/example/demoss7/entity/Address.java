package com.example.demoss7.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street;
    private String city;
@OneToOne(mappedBy = "address")
    @JsonBackReference
    private User user;
}
