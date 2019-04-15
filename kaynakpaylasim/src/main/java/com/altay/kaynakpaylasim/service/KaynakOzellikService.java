package com.altay.kaynakpaylasim.service;

import com.altay.kaynakpaylasim.entity.Bolum;
import com.altay.kaynakpaylasim.entity.Kaynak;
import com.altay.kaynakpaylasim.entity.KaynakOzellik;

import java.util.List;

public interface KaynakOzellikService {
    KaynakOzellik save(KaynakOzellik kaynakOzellik);

    KaynakOzellik getById(Long id);

    List<KaynakOzellik> getAll();

    Boolean delete(Long id);

    KaynakOzellik update(Long id, KaynakOzellik kaynakOzellik);

    List<KaynakOzellik> getAllByBolum(Long b);

    List<KaynakOzellik> getAllByKaynak(Kaynak k);
}
