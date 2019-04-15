package com.altay.kaynakpaylasim.repo;

import com.altay.kaynakpaylasim.entity.Bolum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BolumRep extends JpaRepository<Bolum, Long> {
    List<Bolum> findAllByOrderByOncelikAsc();
}
