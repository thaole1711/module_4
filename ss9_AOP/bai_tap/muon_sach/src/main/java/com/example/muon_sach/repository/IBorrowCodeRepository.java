package com.example.muon_sach.repository;

import com.example.muon_sach.entity.BorrowCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBorrowCodeRepository extends JpaRepository<BorrowCode,Integer> {
    Optional<Object> findBorrowCodeByBorrowCode(String borrowCode);
}
