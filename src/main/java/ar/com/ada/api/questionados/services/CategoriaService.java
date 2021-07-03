package ar.com.ada.api.questionados.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.questionados.entities.Categoria;
import ar.com.ada.api.questionados.repos.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepo;

    public Categoria buscarCategoria(Integer categoriaId){
        Optional<Categoria> resultado = categoriaRepo.findById(categoriaId);
        Categoria categoria = null;

        if (resultado.isPresent())
            categoria = resultado.get();
        
        return categoria;
    }
    
}
