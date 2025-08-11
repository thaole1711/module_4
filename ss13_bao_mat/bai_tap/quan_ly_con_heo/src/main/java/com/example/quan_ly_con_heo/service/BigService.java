package com.example.quan_ly_con_heo.service;

import com.example.quan_ly_con_heo.entity.Big;
import com.example.quan_ly_con_heo.repository.IBigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service

public class BigService implements IBigService {
    @Autowired
    private IBigRepository bigRepository;

    @Override
    public Page<Big> findAll(Pageable pageable) {
        return bigRepository.findAll(pageable);
    }

    @Override
    public Big findById(String id) {
        return bigRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Big> search(String keyword, Integer idCountry, Pageable pageable) {
        return bigRepository.search(keyword, idCountry, pageable);
    }



    @Override
    public void create(Big big) {
        Big lastBig = bigRepository.findTopByOrderByIdBigDesc();
        String newId = "MH-001";
        if (lastBig != null) {
            String lastId = lastBig.getIdBig();
            int number = Integer.parseInt(lastId.substring(3));
            number++;
            newId = String.format("MH-%03d", number);
        }
        big.setIdBig(newId);
        bigRepository.save(big);
    }

    @Override
    public void update(Big big) {
        bigRepository.save(big);
    }

    @Override
    public void delete(Big big) {
        bigRepository.delete(big);
    }
}
