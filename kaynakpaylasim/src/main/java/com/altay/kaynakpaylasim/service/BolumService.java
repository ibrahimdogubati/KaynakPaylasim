package com.altay.kaynakpaylasim.service;

import com.altay.kaynakpaylasim.entity.Bolum;

import java.util.List;

public interface BolumService {
    Bolum save(Bolum bolum);

    Bolum getById(Long id);

    List<Bolum> getAll();

    List<Bolum> getAllOrderByOncelik();

    Boolean delete(Long id);

    Bolum update(Long id, Bolum bolum);


}
