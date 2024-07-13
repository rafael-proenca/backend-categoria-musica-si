package com.utfpr.backendcategoriamusicasi.repository;

import com.utfpr.backendcategoriamusicasi.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository <Categoria,Long> {
}
