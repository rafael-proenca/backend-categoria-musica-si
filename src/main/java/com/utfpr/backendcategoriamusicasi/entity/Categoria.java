package com.utfpr.backendcategoriamusicasi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categoria")
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_categoria", nullable = false)
    private Long id;

    @Column(name="desc_categoria", nullable = false, length = 50)
    private String descCategoria;


}
