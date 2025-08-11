package com.example.quan_ly_con_heo.service;

import com.example.quan_ly_con_heo.entity.Big;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IBigService {
    Page<Big> findAll(Pageable pageable);
    Big  findById(String id);
    Page<Big> search(String keyword,Integer idCountry, Pageable pageable );
    void create(Big big);
    void update(Big big);
    void delete(Big big);

}
