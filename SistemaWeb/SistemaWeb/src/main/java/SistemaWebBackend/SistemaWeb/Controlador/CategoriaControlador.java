package SistemaWebBackend.SistemaWeb.Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SistemaWebBackend.SistemaWeb.Mensaje.Mensaje;
import SistemaWebBackend.SistemaWeb.Modelo.Categoria;
import SistemaWebBackend.SistemaWeb.Servicios.CategoriaServicios;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*")
public class CategoriaControlador {

    @Autowired
    CategoriaServicios categoriaServicios;

    @GetMapping("/listarCategoria")
    public List<Categoria> getListaCategoria() {
        return categoriaServicios.listarCategorias();
    }

    @PostMapping("/guardarCategoria")
    public ResponseEntity<Mensaje> guardarCategoria(@RequestBody Categoria categoria) {
        try {
            categoriaServicios.guardarCategoria(categoria);
            return ResponseEntity.ok(new Mensaje("Bodega guardada correctamente"));


        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Mensaje("Error al guardar la bodega: " + e.getMessage()));
        }
        
    }


    // //metodo para actualizar una categoria
    // @PutMapping("/actualizarCategoria/{id}")
    // public ResponseEntity<Mensaje> actualizarCategoria(@PathVariable int id,@RequestBody Categoria categoria) {
    //     try {
    //         categoria.setNombreCategoria(categoria.getNombreCategoria());
    //         categoria.setBodega(categoria.getBodega());
    //         categoriaServicios.guardarCategoria(categoria);
    //         return ResponseEntity.ok(new Mensaje("Categoria actualizada correctamente"));
    //     } catch (Exception e) {
    //         return ResponseEntity.badRequest().body(new Mensaje("Error al actualizar la bodega: " + e.getMessage()));
    //     }

    // }

    @PutMapping("/actualizarCategoria/{id}")
    public ResponseEntity<Mensaje> actualizarCategoria(@PathVariable int id,@RequestBody Categoria nuevaCategoria) {
    try {
        Optional<Categoria> categoriaOpt = categoriaServicios.getCategoriaById(id);
        if (!categoriaOpt.isPresent()) {
            return ResponseEntity.badRequest().body(new Mensaje("La Categoria con id " + id + " no existe"));
        }
        Categoria categoria = categoriaOpt.get();
        categoria.setNombreCategoria(nuevaCategoria.getNombreCategoria());
       // categoria.setBodega(nuevaCategoria.getBodega());
        categoriaServicios.guardarCategoria(categoria);
        return ResponseEntity.ok(new Mensaje("Categoria actualizada correctamente"));
    } catch (Exception e) {
        return ResponseEntity.badRequest().body(new Mensaje("Error al actualizar la categoria: " + e.getMessage()));
    }
   }


   @DeleteMapping("/eliminarCategoria/{id}")
    public ResponseEntity<Mensaje> borrarCategoria(@PathVariable int id) {
        try {
            Optional<Categoria> categoria = categoriaServicios.borrarCategoria(id);
            if (categoria.isPresent()) {
                return ResponseEntity.ok(new Mensaje("Categoria eliminada correctamente"));
            } else {
                return ResponseEntity.badRequest().body(new Mensaje("Error al eliminar la categoria"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Mensaje("Error al eliminar la categoria: " + e.getMessage()));
        }
    }

    
}
