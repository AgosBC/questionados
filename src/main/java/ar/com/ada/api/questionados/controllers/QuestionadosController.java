package ar.com.ada.api.questionados.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.questionados.entities.Pregunta;
import ar.com.ada.api.questionados.models.request.RespuestaAVerificar;
import ar.com.ada.api.questionados.models.responce.RespuestaVerificada;
import ar.com.ada.api.questionados.services.QuestionadosService;


@RestController
public class QuestionadosController {

    @Autowired
    QuestionadosService service;
    // controller del juego
    //get/quetionados/next


    public ResponseEntity<Pregunta> traerPreguntaRandom(){

        Pregunta proximaPregunta = service.traerPreguntaRandom();

        return ResponseEntity.ok(proximaPregunta);
        
    }

    //verificar si una respuesta es correcta
    @PostMapping
    public ResponseEntity<RespuestaVerificada> verificarRespuesta(@RequestBody RespuestaAVerificar respuestaAVerificar){
        
        RespuestaVerificada respuestaVerificada = new RespuestaVerificada();
        if (service.verificarRespuesta(respuestaAVerificar.preguntaId, respuestaAVerificar.respuestaId)){
            respuestaVerificada.esCorrecta = true;
        }else {
            respuestaVerificada.esCorrecta = false;        
        }

        return ResponseEntity.ok(respuestaVerificada);
    }


    
}
