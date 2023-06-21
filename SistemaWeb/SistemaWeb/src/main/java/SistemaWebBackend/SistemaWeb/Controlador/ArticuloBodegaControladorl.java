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
import SistemaWebBackend.SistemaWeb.Modelo.ArticuloBodega;
import SistemaWebBackend.SistemaWeb.Servicios.ArticuloBodegaServicios;

@RestController
@RequestMapping("/articuloBodega")
@CrossOrigin(origins = "*")
public class ArticuloBodegaControladorl {

    @Autowired
    ArticuloBodegaServicios articuloBodegaServicios;

    @GetMapping("/listarArticulosBodega")
    public List<ArticuloBodega> getListaArticulosBodega() {
        return articuloBodegaServicios.listarArticulosBodega();
    }

    @PostMapping("/guardarArticuloBodega")
    public ResponseEntity<Mensaje> guardarArituloBodega(@RequestBody ArticuloBodega articuloBodega) {
        try {
            articuloBodegaServicios.guardarArticuloBodega(articuloBodega);
            return ResponseEntity.ok(new Mensaje("Articulo Bodega guardado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Mensaje("Error al guardar el articulo bodega"));
        }
    }


    @PutMapping("/actualizarArticuloBodega/{id}")
    public ResponseEntity<Mensaje> actualizarArticuloBodega(@PathVariable int id,@RequestBody ArticuloBodega actualizarArticulo){
    try{
        Optional <ArticuloBodega> articuloBodegaOpt = articuloBodegaServicios.getArticuloBodegaById(id);
        if(!articuloBodegaOpt.isPresent()){
            return ResponseEntity.badRequest().body(new Mensaje("El artículo de la bodega no existe"));
        }
        ArticuloBodega articuloBodegaUpdate = articuloBodegaOpt.get();
        articuloBodegaUpdate.setCodigoArticulo(actualizarArticulo.getCodigoArticulo());
        articuloBodegaUpdate.setBodega(actualizarArticulo.getBodega());
        articuloBodegaUpdate.setExitenciasArticulo(actualizarArticulo.getExitenciasArticulo());
        articuloBodegaUpdate.setCostoPromedioArticulo(actualizarArticulo.getCostoPromedioArticulo());

        articuloBodegaServicios.guardarArticuloBodega(articuloBodegaUpdate);

        return ResponseEntity.ok(new Mensaje("Artículo de la bodega actualizado correctamente"));

    }catch(Exception e){
        return ResponseEntity.badRequest().body(new Mensaje("Error al actualizar el artículo de la bodega"));
    }
    }

    @DeleteMapping("/eliminarArticuloBodega/{id}")
    public ResponseEntity<Mensaje> eliminarArticuloBodega(@PathVariable int id){
        try{
            Optional<ArticuloBodega> articuloBodegaOpt = articuloBodegaServicios.getArticuloBodegaById(id);
            if(!articuloBodegaOpt.isPresent()){
                return ResponseEntity.badRequest().body(new Mensaje("El artículo de la bodega no existe"));
            }else{
                articuloBodegaServicios.borrarArticuloBodega(id);
                return ResponseEntity.ok(new Mensaje("Artículo de la bodega eliminado correctamente"));
            }
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new Mensaje("Error al eliminar el artículo de la bodega"));
        }
    }



    
    
    
}
