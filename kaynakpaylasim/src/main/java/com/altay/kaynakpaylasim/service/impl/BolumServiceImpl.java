package com.altay.kaynakpaylasim.service.impl;

import com.altay.kaynakpaylasim.entity.Bolum;
import com.altay.kaynakpaylasim.repo.BolumRep;
import com.altay.kaynakpaylasim.service.BolumService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BolumServiceImpl implements BolumService {


    private final BolumRep bolumRep ;

    public BolumServiceImpl(BolumRep bolumRep) {
        this.bolumRep = bolumRep;
    }

    @Override
    public Bolum save(Bolum bolum) {
        return bolumRep.save(bolum);
    }

    @Override
    public Bolum getById(Long id) {
        return bolumRep.getOne(id);
    }

    @Override
    public List<Bolum> getAll() {
        return bolumRep.findAll();
    }

    @Override
    public List<Bolum> getAllOrderByOncelik() {
        return bolumRep.findAllByOrderByOncelikAsc();
    }


    @Override
    public Boolean delete(Long id) {
        bolumRep.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public Bolum update(Long id, Bolum bolum) {
        Bolum bdb = bolumRep.getOne(id);
        bdb.setAdet(bolum.getAdet());
        bdb.setName(bolum.getName());
        return bolumRep.save(bdb);
    }
}
