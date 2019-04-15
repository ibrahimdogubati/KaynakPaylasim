package com.altay.kaynakpaylasim.repo;

import com.altay.kaynakpaylasim.entity.Bolum;
import com.altay.kaynakpaylasim.entity.BolumIstekOzellik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BolumIstekOzellikRep extends JpaRepository<BolumIstekOzellik, Long> {
    List<BolumIstekOzellik> findByBolum(Bolum b);
}
