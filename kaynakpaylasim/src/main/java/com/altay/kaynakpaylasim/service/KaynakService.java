package com.altay.kaynakpaylasim.service;

import com.altay.kaynakpaylasim.entity.Kaynak;

import java.util.List;

public interface KaynakService {
    Kaynak save(Kaynak kaynak);

    Kaynak getById(Long id);

    List<Kaynak> getAll();

    List<Kaynak> getAllKaynakNotExistsDagitim();

    Boolean delete(Long id);

    Kaynak update(Long id, Kaynak kaynak);

}
