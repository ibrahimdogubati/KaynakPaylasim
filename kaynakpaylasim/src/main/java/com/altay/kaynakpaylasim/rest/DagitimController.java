package com.altay.kaynakpaylasim.rest;

import com.altay.kaynakpaylasim.entity.Dagitim;
import com.altay.kaynakpaylasim.service.impl.DagitimServiceImpl;
import com.altay.kaynakpaylasim.util.DagitimUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dagitim")
public class DagitimController {
    private final DagitimServiceImpl service;
    private final DagitimUtil util;

    public DagitimController(DagitimServiceImpl service, DagitimUtil util) {
        this.service = service;
        this.util = util;
    }

    @GetMapping
    public ResponseEntity<List<Dagitim>> getAll(){
        List<Dagitim> list = service.getAll();
        if (list.isEmpty()) {
            util.dagitimHazirlik();
            list = service.getAll();
        }

        return ResponseEntity.ok(list);
    }
}
