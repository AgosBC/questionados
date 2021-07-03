package ar.com.ada.api.questionados.entities;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "pregunta")
public class Pregunta {

    
    @Id
    @Column(name = "pregunta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String enunciado;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id")
    private Categoria categoria;
   
   @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Respuesta> opciones  = new ArrayList<>();

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }    
    
    public String getEnunciado() {
        return enunciado;
    }
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
        this.categoria.agregarPregunta(this);
    }
    public List<Respuesta> getOpciones() {
        return opciones;
    }
    public void setOpciones(List<Respuesta> opciones) {
        this.opciones = opciones;
    }

    public void agregarRespuesta(Respuesta respuesta){
        this.opciones.add(respuesta);
    }

    
}
