package com.altay.kaynakpaylasim.rest;



import com.altay.kaynakpaylasim.entity.KaynakOzellik;
import com.altay.kaynakpaylasim.service.impl.KaynakOzellikServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/kaynakozellik")

public class KaynakOzellikController {

    private final KaynakOzellikServiceImpl service;

    public KaynakOzellikController(KaynakOzellikServiceImpl service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<KaynakOzellik>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<KaynakOzellik> getById(@PathVariable(value = "id", required = true) Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<KaynakOzellik> createKaynakOzellik(@Valid @RequestBody KaynakOzellik k) {
        return ResponseEntity.ok(service.save(k));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<KaynakOzellik> updateKaynakOzellik(@PathVariable (value = "id", required = true) Long id, @Valid @RequestBody KaynakOzellik k) {
        return ResponseEntity.ok(service.update(id, k));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteKaynakOzellik(@PathVariable (value = "id", required = true) Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

}
