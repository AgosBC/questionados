package ar.com.ada.api.questionados.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.questionados.entities.Pregunta;
import ar.com.ada.api.questionados.models.request.InfoPreguntaNueva;
import ar.com.ada.api.questionados.models.responce.GenericResponse;
import ar.com.ada.api.questionados.services.PreguntaService;

@RestController
public class PreguntaController {

    @Autowired
    private PreguntaService service;


    @GetMapping("/preguntas")
    public ResponseEntity<List<Pregunta>> traerPreguntas() {

        return ResponseEntity.ok(service.traerPreguntas());

    }

    @GetMapping("/preguntas/{id}")
    public ResponseEntity<Pregunta> traerPreguntaPorId(@PathVariable Integer id){

        return ResponseEntity.ok(service.buscarPreguntaPorId(id));
    }     


    @PostMapping("/preguntas")
    public ResponseEntity<?> crearPregunta(@RequestBody InfoPreguntaNueva preguntaNueva){
       
        GenericResponse r = new GenericResponse();

        Pregunta pregunta = service.crearPregunta(preguntaNueva.enunciado, preguntaNueva.categoriaId, preguntaNueva.opciones);
        r.isOk = true;
        r.message="La pregunta fue creada con exito";
        r.id = pregunta.getPreguntaId();

        return ResponseEntity.ok(preguntaNueva);
        

    }

    

    
}
