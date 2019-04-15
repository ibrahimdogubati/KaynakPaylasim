package com.altay.kaynakpaylasim.repo;

import com.altay.kaynakpaylasim.entity.Bolum;
import com.altay.kaynakpaylasim.entity.Kaynak;
import com.altay.kaynakpaylasim.entity.KaynakOzellik;
import com.altay.kaynakpaylasim.entity.OzellikTur;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;
import java.util.List;

public interface KaynakOzellikRep extends JpaRepository<KaynakOzellik, Long> {
    List<KaynakOzellik> findByKaynak(Kaynak k);

    @Query(value = "SELECT KK.ID AS ID , KK.DURUM AS DURUM, KAYNAK_ID AS KAYNAK_ID, KAYNAK_OZELLIK_ID AS KAYNAK_OZELLIK_ID FROM KAYNAK_OZELLIK AS KK WHERE KK.KAYNAK_OZELLIK_ID IN " +
            "(SELECT BK.OZELLIK_ID AS OZELLIK_ID FROM BOLUM_ISTEK AS BK WHERE BK.BOLUM_ID = :deger)",nativeQuery = true)

    List<KaynakOzellik> findKaynakOzellikByBolum(@Param("deger") Long b);



}
