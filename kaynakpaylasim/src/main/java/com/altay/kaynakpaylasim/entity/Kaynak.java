package com.altay.kaynakpaylasim.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "kaynak")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Kaynak implements Serializable {



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
