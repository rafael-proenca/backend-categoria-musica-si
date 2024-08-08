package com.utfpr.backendcategoriamusicasi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="musica")
@Data
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_musica",nullable = false)
    private Long codMusica;


    @ManyToOne
    @JoinColumn(name = "cod_categoria", nullable = false)
    private Categoria codCategoria;

    private int duracao;

    @Column(length = 100)
    private String titulo;


}
