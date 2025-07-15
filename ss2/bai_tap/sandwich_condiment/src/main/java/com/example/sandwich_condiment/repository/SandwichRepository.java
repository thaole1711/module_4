package com.example.sandwich_condiment.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Array;
@Repository
public class SandwichRepository implements ISandwichRepository {
    private String[] sandwichs= {"Lettuce","Tomato","Mustard","Spouts"};
    @Autowired
    public String[] display(){
        return sandwichs;

    }

}
