package com.altay.kaynakpaylasim.service.impl;

import com.altay.kaynakpaylasim.entity.Bolum;
import com.altay.kaynakpaylasim.entity.BolumIstekOzellik;
import com.altay.kaynakpaylasim.repo.BolumIstekOzellikRep;
import com.altay.kaynakpaylasim.service.BolumIstekOzellikService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BolumIstekOzellikServiceImpl implements BolumIstekOzellikService {

    private final BolumIstekOzellikRep ozellikRep;

    public BolumIstekOzellikServiceImpl(BolumIstekOzellikRep ozellikRep) {
        this.ozellikRep = ozellikRep;
    }

    @Override
    public BolumIstekOzellik save(BolumIstekOzellik bolumIstekOzellik) {
        return ozellikRep.save(bolumIstekOzellik);
    }

    @Override
    public BolumIstekOzellik getById(Long id) {
        return ozellikRep.getOne(id);
    }

    @Override
    public List<BolumIstekOzellik> getAll() {
        return ozellikRep.findAll();
    }


    @Override
    public Boolean delete(Long id) {
        ozellikRep.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public BolumIstekOzellik update(Long id, BolumIstekOzellik bolumIstekOzellik) {
        BolumIstekOzellik bd = ozellikRep.getOne(id);
        bd.setBolum(bolumIstekOzellik.getBolum());
        bd.setOzellikTur(bolumIstekOzellik.getOzellikTur());
        return ozellikRep.save(bd);
    }

    public List<BolumIstekOzellik> getAllByBolum(Bolum b){
        return  ozellikRep.findByBolum(b);
    }
}
