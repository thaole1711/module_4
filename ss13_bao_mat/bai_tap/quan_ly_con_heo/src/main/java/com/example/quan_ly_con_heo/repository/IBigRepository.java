package com.example.quan_ly_con_heo.repository;

import com.example.quan_ly_con_heo.entity.Big;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface IBigRepository extends JpaRepository<Big,String> {
   Big findTopByOrderByIdBigDesc();
   @Query("SELECT b FROM Big b WHERE (b.countryOrigin.idCountry = :idCountry OR :idCountry = 0) AND (b.idBig LIKE CONCAT('%', :keyword, '%'))")
   Page<Big> search(@RequestParam (name="keyword")String keyword,
                    @RequestParam(name="idCountry") Integer idCountry,
                     Pageable pageable);
}

