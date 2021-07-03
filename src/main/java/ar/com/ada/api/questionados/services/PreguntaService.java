package ar.com.ada.api.questionados.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.ada.api.questionados.entities.Categoria;
import ar.com.ada.api.questionados.entities.Pregunta;
import ar.com.ada.api.questionados.entities.Respuesta;
import ar.com.ada.api.questionados.repos.*;


@Service
public class PreguntaService {

    @Autowired
    PreguntaRepository repo;

    @Autowired 
    RespuestaRepository respuestaRepo;

    @Autowired
    CategoriaService categoriaService;

    

    
    public Pregunta agregarPregunta(String enunciado, String opcion1, String opcion2, String opcion3, Integer categoriaId){
        Pregunta pregunta = new Pregunta();
        pregunta.setEnunciado(enunciado);
        Categoria categoria = categoriaService.buscarCategoria(categoriaId);
        pregunta.setCategoria(categoria);
        repo.save(pregunta);

        Respuesta respuesta = new Respuesta();
        
        
        
       // tiene que agregar un objeto de tipo respuesta
        
        
        return pregunta;
    }
    


}
