package controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.questionados.entities.Pregunta;
import ar.com.ada.api.questionados.entities.Respuesta;
import ar.com.ada.api.questionados.models.request.InfoPreguntaNueva;
import ar.com.ada.api.questionados.models.responce.GenericResponse;
import ar.com.ada.api.questionados.services.PreguntaService;
import ar.com.ada.api.questionados.services.RespuestaService;

@RestController
public class PreguntaController {

    private PreguntaService service;

    private RespuestaService respuestaService;


    @PostMapping("/pregunta")
    public ResponseEntity<?> agregarPregunta(@RequestBody InfoPreguntaNueva preguntaNueva){
        GenericResponse r = new GenericResponse();

        Pregunta pregunta = service.agregarPregunta(preguntaNueva.enunciado, preguntaNueva.categoriaId);

        Respuesta respuesta = service.agregarRespuesta(preguntaNueva.opcion1, preguntaNueva.opcion2, preguntaNueva.opcoion3);

    }

          }

    
}
