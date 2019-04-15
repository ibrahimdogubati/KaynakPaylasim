package com.altay.kaynakpaylasim.service.impl;

import com.altay.kaynakpaylasim.entity.OzellikTur;
import com.altay.kaynakpaylasim.repo.OzellikTurRep;
import com.altay.kaynakpaylasim.service.OzellikTurService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OzellikTurServiceImpl implements OzellikTurService {

    private final OzellikTurRep rep ;

    public OzellikTurServiceImpl(OzellikTurRep rep) {
        this.rep = rep;
    }


    @Override
    public OzellikTur save(OzellikTur ozellikTur) {
        return null;
    }

    @Override
    public OzellikTur getById(Long id) {
        return rep.getOne(id);
    }

    @Override
    public List<OzellikTur> getAll() {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public OzellikTur update(Long id, OzellikTur ozellikTur) {
        return null;
    }
}
