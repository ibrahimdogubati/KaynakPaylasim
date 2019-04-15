package com.altay.kaynakpaylasim.entity;

import com.altay.kaynakpaylasim.enu.OzellikDurum;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "bolum_istek")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class BolumIstekOzellik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bolum_id")
    private Bolum bolum;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ozellik_id")
    private OzellikTur ozellikTur;
    @Column(name = "durum")
    private int durum;
}
