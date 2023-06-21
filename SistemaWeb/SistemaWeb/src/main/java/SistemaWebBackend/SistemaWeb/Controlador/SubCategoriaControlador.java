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
import SistemaWebBackend.SistemaWeb.Modelo.SubCategoria;
import SistemaWebBackend.SistemaWeb.Servicios.SubCategoriaServicios;

@RestController
@RequestMapping("/subcategoria")
@CrossOrigin(origins = "*")
public class SubCategoriaControlador {

    @Autowired
    SubCategoriaServicios subCategoriaServicios;

    @GetMapping("/listarSubCategoria")
    public List<SubCategoria> getListaSubCategoria() {
        return subCategoriaServicios.listarSubCategorias();
    }

    @PostMapping("/guardarSubCategoria")
    public ResponseEntity<Mensaje> guardarSubCategoria(@RequestBody SubCategoria subCategoria) {
        try {
            subCategoriaServicios.guardarSubCategoria(subCategoria);
            return ResponseEntity.ok(new Mensaje("Sub Categoria guardada correctamente"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Mensaje("Error al guardar la Sub Categoria: " + e.getMessage()));
        }
    }

    @PutMapping("/actualizarSubCategoria/{id}")
    public ResponseEntity<Mensaje> actualizarCategoria(@PathVariable int id,@RequestBody SubCategoria nuevaSubCategoria) {

        try{
            Optional<SubCategoria> subCategoriaOpt = subCategoriaServicios.getSubCategoriaById(id);

            if(!subCategoriaOpt.isPresent()){
                return ResponseEntity.badRequest().body(new Mensaje("La Sub Categoria con id " + id + " no existe"));
            }else{
                SubCategoria subCategoria = subCategoriaOpt.get();
                subCategoria.setSubCategoria(nuevaSubCategoria.getSubCategoria());
                subCategoria.setCategoria(nuevaSubCategoria.getCategoria());
                //subCategoria.setBodega(nuevaSubCategoria.getBodega());

                subCategoriaServicios.guardarSubCategoria(subCategoria);
                return ResponseEntity.ok(new Mensaje("Sub Categoria actualizada correctamente"));
            }
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new Mensaje("Error al actualizar la Sub Categoria: " + e.getMessage()));
        }

    }

    //eliminar
    @DeleteMapping("/eliminarSubCategoria/{id}")
    public ResponseEntity<Mensaje> eliminarSubCategoria(@PathVariable int id){
        try{
            Optional<SubCategoria> subCategoriaOpt = subCategoriaServicios.getSubCategoriaById(id);

            if(!subCategoriaOpt.isPresent()){
                return ResponseEntity.badRequest().body(new Mensaje("La Sub Categoria con id " + id + " no existe"));
            }else{
                subCategoriaServicios.borrarSubCategoria(id);
                return ResponseEntity.ok(new Mensaje("Sub Categoria eliminada correctamente"));
            }
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new Mensaje("Error al eliminar la Sub Categoria: " + e.getMessage()));
        }
    }


    
}
