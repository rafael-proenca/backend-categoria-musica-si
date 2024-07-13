package com.utfpr.backendcategoriamusicasi.repository;

import com.utfpr.backendcategoriamusicasi.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository<Musica,Long> {
}
