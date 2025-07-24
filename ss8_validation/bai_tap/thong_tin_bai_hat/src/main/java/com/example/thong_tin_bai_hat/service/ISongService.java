package com.example.thong_tin_bai_hat.service;


import com.example.thong_tin_bai_hat.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    boolean update(Song song);

    Song findById(Integer id);

    void save(Song song);
}
