package com.altay.kaynakpaylasim.entity;

import com.altay.kaynakpaylasim.enu.OzellikDurum;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "kaynak_ozellik")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class KaynakOzellik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kaynak_id")
    private Kaynak kaynak;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kaynak_ozellik_id")
    private OzellikTur kaynakOzellik;
    @Column(name = "durum")
    private int durum;
}
