package com.altay.kaynakpaylasim.service;

import com.altay.kaynakpaylasim.entity.Dagitim;

import java.util.List;

public interface DagitimService {
    Dagitim save(Dagitim dagitim);

    Dagitim getById(Long id);

    List<Dagitim> getAll();

    Boolean delete(Long id);

    Dagitim update(Long id, Dagitim dagitim);
}
