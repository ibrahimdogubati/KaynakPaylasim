package com.altay.kaynakpaylasim.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ozellik_tur")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class OzellikTur  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name="adi")
    private String adi;

    @Override
    public String toString() {
        return adi;
    }
}
