package ar.com.ada.api.questionados.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "respuesta")
public class Respuesta {

    @Id
    @Column(name = "respuesta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer respuestaId;

    private String texto;

    @Column(name = "es_correcta")
    private boolean esCorrecta;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pregunta_id", referencedColumnName = "pregunta_id")
    private Pregunta pregunta;

    public Integer getRespuesta_id() {
        return respuestaId;
    }

    public void setRespuesta_id(Integer respuesta_id) {
        this.respuestaId = respuesta_id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
        this.pregunta.agregarRespuesta(this); // relacion bidireccional
    }

}
