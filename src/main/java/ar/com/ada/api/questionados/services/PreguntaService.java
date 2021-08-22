package ar.com.ada.api.questionados.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.questionados.entities.Categoria;
import ar.com.ada.api.questionados.entities.Pregunta;
import ar.com.ada.api.questionados.entities.Respuesta;
import ar.com.ada.api.questionados.models.responce.OpcionPregunta;
import ar.com.ada.api.questionados.repos.*;

@Service
public class PreguntaService {

    @Autowired
    PreguntaRepository repo;

    @Autowired
    CategoriaService categoriaService;

    public List<Pregunta> traerPreguntas() {
        return repo.findAll();
    }

    public Pregunta buscarPreguntaPorId(Integer preguntaId) {
        Optional<Pregunta> resultado = repo.findById(preguntaId);

        if (resultado.isPresent()) {
            return resultado.get();
        }
        return null;

    }

    public Pregunta crearPregunta(String enunciado, Integer categoriaId, List<Respuesta> opciones) {

        Pregunta pregunta = new Pregunta();
        pregunta.setEnunciado(enunciado);
        Categoria categoria = categoriaService.buscarCategoria(categoriaId);
        pregunta.setCategoria(categoria);

        for (Respuesta respuesta : opciones) { // por cada respuesta, agregarla a la pregunta
            respuesta.setPregunta(pregunta);

        }
        repo.save(pregunta);
        return pregunta;

    }

    public Pregunta buscar(Integer id) {

        Optional<Pregunta> pregunta = repo.findById(id);

        if (pregunta.isPresent()) {

            return pregunta.get();

        }
        return null;

    }

    public void borrar(Integer id) {

        Pregunta pregunta = repo.findByPreguntaId(id);

        repo.delete(pregunta);

    }

}
