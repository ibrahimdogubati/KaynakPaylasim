package com.altay.kaynakpaylasim.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "dagitim")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dagitim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bolum_id")
    private Bolum bolum;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kaynak_id")
    private Kaynak kaynak;
}
