package com.utfpr.backendcategoriamusicasi.service;

import com.utfpr.backendcategoriamusicasi.entity.Categoria;
import com.utfpr.backendcategoriamusicasi.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> listarTodasAsCategorias() {
        return repository.findAll();
    }
}
