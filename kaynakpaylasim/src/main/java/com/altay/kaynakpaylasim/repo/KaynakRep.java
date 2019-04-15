package com.altay.kaynakpaylasim.repo;

import com.altay.kaynakpaylasim.entity.Kaynak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KaynakRep extends JpaRepository<Kaynak, Long> {

    @Query(value = "SELECT * FROM KAYNAK AS K WHERE NOT EXISTS (SELECT * FROM DAGITIM AS D WHERE D.KAYNAK_ID = K.ID )", nativeQuery = true)
    List<Kaynak> findAllKaynakNotExistsDagitim();
}
