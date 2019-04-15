package com.altay.kaynakpaylasim.service.impl;

import com.altay.kaynakpaylasim.entity.Kaynak;
import com.altay.kaynakpaylasim.repo.KaynakRep;
import com.altay.kaynakpaylasim.service.KaynakService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KaynakServiceImpl implements KaynakService {
    private final KaynakRep kaynakRep;

    public KaynakServiceImpl(KaynakRep kaynakRep) {
        this.kaynakRep = kaynakRep;
    }

    @Override
    public Kaynak save(Kaynak kaynak) {
        return kaynakRep.save(kaynak);
    }

    @Override
    public Kaynak getById(Long id) {
        return kaynakRep.getOne(id);
    }

    @Override
    public List<Kaynak> getAll() {
        return kaynakRep.findAll();
    }

    @Override
    public List<Kaynak> getAllKaynakNotExistsDagitim() {
        return kaynakRep.findAllKaynakNotExistsDagitim();
    }

    @Override
    public Boolean delete(Long id) {
        kaynakRep.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public Kaynak update(Long id, Kaynak kaynak) {
        Kaynak kdb = kaynakRep.getOne(id);
        kdb.setAdi(kaynak.getAdi());
        return kaynakRep.save(kaynak);
    }


}
