package com.altay.kaynakpaylasim.service.impl;

import com.altay.kaynakpaylasim.entity.Kaynak;
import com.altay.kaynakpaylasim.entity.KaynakOzellik;
import com.altay.kaynakpaylasim.repo.KaynakOzellikRep;
import com.altay.kaynakpaylasim.service.KaynakOzellikService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KaynakOzellikServiceImpl implements KaynakOzellikService {

    private final KaynakOzellikRep ozellikRep;

    public KaynakOzellikServiceImpl(KaynakOzellikRep ozellikRep) {
        this.ozellikRep = ozellikRep;
    }

    @Override
    public KaynakOzellik save(KaynakOzellik kaynakOzellik) {
        return ozellikRep.save(kaynakOzellik);
    }

    @Override
    public KaynakOzellik getById(Long id) {
        return ozellikRep.getOne(id);
    }

    @Override
    public List<KaynakOzellik> getAll() {
        return ozellikRep.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        ozellikRep.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public KaynakOzellik update(Long id, KaynakOzellik kaynakOzellik) {
        KaynakOzellik kdb = ozellikRep.getOne(id);
        kdb.setKaynakOzellik(kaynakOzellik.getKaynakOzellik());
        return ozellikRep.save(kdb);
    }

    @Override
    public List<KaynakOzellik> getAllByBolum(Long b) {
        return ozellikRep.findKaynakOzellikByBolum(b);
    }

    @Override
    public List<KaynakOzellik> getAllByKaynak(Kaynak k) {
        return ozellikRep.findByKaynak(k);
    }

}
