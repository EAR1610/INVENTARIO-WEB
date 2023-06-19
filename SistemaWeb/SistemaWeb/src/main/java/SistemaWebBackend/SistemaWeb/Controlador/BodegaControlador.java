package SistemaWebBackend.SistemaWeb.Controlador;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import SistemaWebBackend.SistemaWeb.Modelo.Bodega;
import SistemaWebBackend.SistemaWeb.Servicios.BodegaServicios;

@RestController
@RequestMapping("/bodega")
@CrossOrigin(origins = "*")
public class BodegaControlador {

    @Autowired
    BodegaServicios bodegaServicios;

    @GetMapping("/listarBodega")
    public List<Bodega> getListaBodega() {
        return bodegaServicios.listarBodegas();
    }

    @PostMapping("/guardarBodega")
    public ResponseEntity<Mensaje> guardarBodega (@RequestBody Bodega bodega){
        try{
        bodegaServicios.guardarBodega(bodega);
         return ResponseEntity.ok(new Mensaje("Bodega guardada correctamente"));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new Mensaje("Error al guardar la bodega"));
        }    
    }
    
    @PutMapping("/actualizarBodega/{id}")
    public ResponseEntity<?> actualizarPiloto(@PathVariable int id, @RequestBody Bodega bodega) {
        try {
            bodega.setNombreBodega(bodega.getNombreBodega());
            bodega.setObservacionBodega(bodega.getObservacionBodega());
            bodega.setPrincipalBodega(bodega.isPrincipalBodega());
            //bodega.setImagenBodega(bodega.getImagenBodega());
            bodegaServicios.guardarBodega(bodega);
            return ResponseEntity.ok(new Mensaje("Bodega actualizada correctamente"));
           
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Mensaje("Error al actualizar la bodega"));
        }
    }

    
    //en el metodo de eliminar solo cambiaremos el estado de la bodega a false
    @DeleteMapping("/eliminarBodega/{id}")
    public ResponseEntity<Mensaje> eliminarBodega(@PathVariable int id){
    try{
        Optional<Bodega> bodega = bodegaServicios.borrarBodega(id);
        if (bodega.isPresent()) {
            return ResponseEntity.ok(new Mensaje("Bodega eliminada correctamente"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje("Bodega no encontrada"));
        }
    } catch(Exception e){
        return ResponseEntity.badRequest().body(new Mensaje("Error al eliminar la bodega"));
    }
   }

    
}
