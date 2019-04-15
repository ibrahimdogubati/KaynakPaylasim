package com.altay.kaynakpaylasim.service;

import com.altay.kaynakpaylasim.entity.BolumIstekOzellik;

import java.util.List;

public interface BolumIstekOzellikService {
    BolumIstekOzellik save(BolumIstekOzellik bolumIstekOzellik);

    BolumIstekOzellik getById(Long id);

    List<BolumIstekOzellik> getAll();

    Boolean delete(Long id);

    BolumIstekOzellik update(Long id, BolumIstekOzellik bolumIstekOzellik);
}
