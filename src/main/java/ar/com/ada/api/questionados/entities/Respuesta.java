package ar.com.ada.api.questionados.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "respuesta")
public class Respuesta {

    @Id
    @Column(name = "respuesta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer respuesta_id;
    
    private String texto;
    private boolean esCorrecta;

    @ManyToOne
    @JoinColumn(name = "pregunta_id", referencedColumnName = "pregunta_id")
    private Pregunta pregunta;



    public Integer getRespuesta_id() {
        return respuesta_id;
    }
    public void setRespuesta_id(Integer respuesta_id) {
        this.respuesta_id = respuesta_id;
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
    }

    


    
}
