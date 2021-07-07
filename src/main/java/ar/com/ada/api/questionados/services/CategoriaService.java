package ar.com.ada.api.questionados.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.questionados.entities.Categoria;
import ar.com.ada.api.questionados.models.request.CategoriaNuevaInfo;
import ar.com.ada.api.questionados.repos.CategoriaRepository;


@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repo;

    public List<Categoria> traerCategorias(){
        return repo.findAll();
    }

    public Categoria buscarCategoria(Integer categoriaId){
        Optional<Categoria> resultado = repo.findById(categoriaId);
        Categoria categoria = null;

        if (resultado.isPresent())
            categoria = resultado.get();

        return categoria;

    }

    // opcion para evitar el opcional

    public Categoria buscarCategoriaV2 (Integer categoriaId){

        Categoria categoria = repo.findById(categoriaId.intValue());// para esto debe estar la info en categoria repo

        return categoria;

    }
    // crear una categoria donde se devuelve un verdadero o falso si existe o no
    public boolean crearCategoria(Categoria categoria){
        if(existe(categoria.getNombre())){
            return false;
        }
        repo.save(categoria);
        return true; 
    }

    // metodo existe para ver si una categoria a esta ingresada o no
    public boolean existe(String nombre){
        Categoria categoria = repo.findByNombre(nombre);
        return categoria != null;
    }
    
    //otra opcion de la funcion existe que utiliza la opcion agregada en la interfaz del repo

    public boolean existeV2(String nombre){
        return repo.existsByNombre(nombre);
    }

    public void actualizar(Integer Id, CategoriaNuevaInfo categoriaNuevaInfo) {

        Categoria categoria = this.buscar(Id);
        categoria.setNombre(categoriaNuevaInfo.otroNombre);
        categoria.setDescripcion(categoriaNuevaInfo.otraDescripcion);
        repo.save(categoria);

    }

    public void eliminar(Integer id){
        Categoria categoria = this.buscar(id);
        repo.delete(categoria);
    }

    public Categoria buscar(Integer categoriaId) { // busca una por id

        Categoria categoria = repo.findById(categoriaId.intValue());

        return categoria;

    }
}
