package com.utfpr.backendcategoriamusicasi.repository;

import com.utfpr.backendcategoriamusicasi.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface MusicaRepository extends JpaRepository<Musica,Long> {

    @Procedure("proc_adicione_tempo")
    void procAdicioneTempo(Integer tempo);

    @Procedure("proc_subtrai_tempo")
    void procSubtraiTempo(Integer tempo);
}

