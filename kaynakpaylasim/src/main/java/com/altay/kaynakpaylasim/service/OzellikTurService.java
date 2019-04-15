package com.altay.kaynakpaylasim.service;

import com.altay.kaynakpaylasim.entity.OzellikTur;

import java.util.List;

public interface OzellikTurService {
    OzellikTur save(OzellikTur ozellikTur);

    OzellikTur getById(Long id);

    List<OzellikTur> getAll();

    Boolean delete(Long id);

    OzellikTur update(Long id, OzellikTur ozellikTur);
}
