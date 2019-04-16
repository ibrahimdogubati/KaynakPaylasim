package com.altay.kaynakpaylasim.rest;

import com.altay.kaynakpaylasim.entity.BolumIstekOzellik;
import com.altay.kaynakpaylasim.service.impl.BolumIstekOzellikServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/bolumistek")

public class BolumOzellikController {
    private final BolumIstekOzellikServiceImpl service;

    public BolumOzellikController(BolumIstekOzellikServiceImpl service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<BolumIstekOzellik>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BolumIstekOzellik> getById(@PathVariable(value = "id", required = true) Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<BolumIstekOzellik> createBolumIstekOzellik(@Valid @RequestBody BolumIstekOzellik k) {
        return ResponseEntity.ok(service.save(k));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BolumIstekOzellik> updateBolumIstekOzellik(@PathVariable (value = "id", required = true) Long id, @Valid @RequestBody BolumIstekOzellik k) {
        return ResponseEntity.ok(service.update(id, k));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteBolumIstekOzellik(@PathVariable (value = "id", required = true) Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
