package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.questionados.entities.Categoria;
import ar.com.ada.api.questionados.models.responce.GenericResponse;
import ar.com.ada.api.questionados.services.CategoriaService;

@RestController
public class CategoriaController {

    @Autowired
    CategoriaService service;

    // get/categorias
    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> traerCategorias(){

        return ResponseEntity.ok(service.traerCategorias());
    }

    //get /categoria/{id}

    @GetMapping("/categoria/{id}")
    public ResponseEntity<Categoria> traerCategoriaPorId(@PathVariable Integer id){
        return ResponseEntity.ok(service.buscarCategoria(id));
    }

    //post categoria
    @PostMapping("/categoria")
    public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria){

        GenericResponse r = new GenericResponse();

        if(service.crearCategoria(categoria)) {
            r.id = categoria.getCategoriaId();
            r.isOk = true;
            r.message = "categoria creada con exito";
            return ResponseEntity.ok(r);
        }else{
            r.isOk= false;
            r.message = "la categoria ya existe";
            return ResponseEntity.badRequest().body(r);
        }
        
    }
}
