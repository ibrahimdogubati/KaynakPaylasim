package com.altay.kaynakpaylasim.repo;

import com.altay.kaynakpaylasim.entity.Dagitim;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;
import java.util.List;

public interface DagitimRep extends JpaRepository<Dagitim, Long> {

}
