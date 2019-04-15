package com.altay.kaynakpaylasim.service.impl;

import com.altay.kaynakpaylasim.entity.Dagitim;
import com.altay.kaynakpaylasim.repo.DagitimRep;
import com.altay.kaynakpaylasim.service.DagitimService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DagitimServiceImpl implements DagitimService {

    private final DagitimRep rep;

    public DagitimServiceImpl(DagitimRep rep) {
        this.rep = rep;
    }


    @Override
    public Dagitim save(Dagitim dagitim) {
        return rep.save(dagitim);
    }

    @Override
    public Dagitim getById(Long id) {
        return rep.getOne(id);
    }

    @Override
    public List<Dagitim> getAll() {
        return rep.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        rep.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public Dagitim update(Long id, Dagitim dagitim) {
        Dagitim ddb = rep.getOne(id);
        ddb.setBolum(dagitim.getBolum());
        ddb.setKaynak(dagitim.getKaynak());
        rep.save(ddb);
        return null;
    }
}
