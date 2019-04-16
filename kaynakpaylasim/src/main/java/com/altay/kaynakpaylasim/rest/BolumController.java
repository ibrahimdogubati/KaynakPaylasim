package com.altay.kaynakpaylasim.rest;

import com.altay.kaynakpaylasim.entity.Bolum;
import com.altay.kaynakpaylasim.service.impl.BolumServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/bolum")

public class BolumController {
    private final BolumServiceImpl service;

    public BolumController(BolumServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Bolum>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Bolum> getById(@PathVariable(value = "id", required = true) Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Bolum> createBolum(@Valid @RequestBody Bolum b) {
        return ResponseEntity.ok(service.save(b));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Bolum> updateBolum(@PathVariable (value = "id", required = true) Long id, @Valid @RequestBody Bolum b) {
        return ResponseEntity.ok(service.update(id, b));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteBolum(@PathVariable (value = "id", required = true) Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

}
