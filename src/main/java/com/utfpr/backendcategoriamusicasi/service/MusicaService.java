package com.utfpr.backendcategoriamusicasi.service;

import com.utfpr.backendcategoriamusicasi.entity.Musica;
import com.utfpr.backendcategoriamusicasi.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository repository;

    public List<Musica> listarTodasAsMusicas(){
        return repository.findAll();
    }

}
