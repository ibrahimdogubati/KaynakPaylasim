package com.altay.kaynakpaylasim.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bolum")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Bolum implements Serializable {

    private static final long serialVersionUID = 4967383498113318791L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "adi")
    private String name;
    @Column(name = "adet")
    private int adet;
    @Column(name="oncelik")
    private int oncelik;

    @Override
    public String toString() {
        return name;
    }
}
