package ar.com.ada.api.questionados.entities;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Integer categoriaId;

    private String nombre;

    private String descripcion;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pregunta> preguntas = new ArrayList<>();

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public void agregarPregunta(Pregunta pregunta) {
        this.preguntas.add(pregunta);
        //pregunta.setCategoria(this);
    }

}
