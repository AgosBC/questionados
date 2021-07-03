package ar.com.ada.api.questionados.entities;

import java.util.*;

import javax.persistence.*;


@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @Column(name = "categoria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String descripcion;

    @OneToMany (mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pregunta> preguntas  = new ArrayList<>();

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setDescripcion(String descripcion){
        this.descripcion= descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public void agregarPregunta(Pregunta pregunta){
        this.preguntas.add(pregunta);
    }

    
    
}


