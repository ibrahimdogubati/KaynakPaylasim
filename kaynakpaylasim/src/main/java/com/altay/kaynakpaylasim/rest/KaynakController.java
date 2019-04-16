package com.altay.kaynakpaylasim.rest;

import com.altay.kaynakpaylasim.entity.Kaynak;
import com.altay.kaynakpaylasim.service.impl.KaynakServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/kaynak")
public class KaynakController {

    private final KaynakServiceImpl service;

    public KaynakController(KaynakServiceImpl service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Kaynak>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Kaynak> getById(@PathVariable(value = "id", required = true) Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Kaynak> createKaynak(@Valid @RequestBody Kaynak k) {
        return ResponseEntity.ok(service.save(k));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Kaynak> updateKaynak(@PathVariable (value = "id", required = true) Long id, @Valid @RequestBody Kaynak k) {
        return ResponseEntity.ok(service.update(id, k));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteKaynak(@PathVariable (value = "id", required = true) Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

}
