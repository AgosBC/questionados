package ar.com.ada.api.questionados.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.questionados.entities.Pregunta;
import ar.com.ada.api.questionados.models.request.RespuestaAVerificar;
import ar.com.ada.api.questionados.models.responce.PreguntaAResolver;
import ar.com.ada.api.questionados.models.responce.RespuestaVerificada;
import ar.com.ada.api.questionados.services.QuestionadosService;

@RestController
public class QuestionadosController {

    @Autowired
    QuestionadosService service;
    // controller del juego
    // get/quetionados/next

    @GetMapping("/questionados/next")
    public ResponseEntity<PreguntaAResolver> traerPreguntaRandom() {

        Pregunta pregunta = service.traerPreguntaRandom();

        PreguntaAResolver preguntaAResolver = PreguntaAResolver.convertirDesde(pregunta);

        return ResponseEntity.ok(preguntaAResolver);

    }

    // verificar si una respuesta es correcta
    @PostMapping("/questionados/verificaciones")
    public ResponseEntity<RespuestaVerificada> verificarRespuesta(
            @RequestBody RespuestaAVerificar respuestaAVerificar) {

        RespuestaVerificada respuestaVerificada = new RespuestaVerificada();
        if (service.verificarRespuesta(respuestaAVerificar.preguntaId, respuestaAVerificar.respuestaId)) {
            respuestaVerificada.esCorrecta = true;
        } else {
            respuestaVerificada.esCorrecta = false;
        }

        return ResponseEntity.ok(respuestaVerificada);
    }

}
