package com.example.muon_sach.service;

import com.example.muon_sach.entity.BorrowCode;

public interface IBorrowCodeService  {
    BorrowCode findByBorrowCode(String id);
    void add(BorrowCode borrowCode);
    void softDelete(BorrowCode borrowCode);
}
