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
import SistemaWebBackend.SistemaWeb.Modelo.SubUbicacion;
import SistemaWebBackend.SistemaWeb.Servicios.SubUbicacionServicios;

@RestController
@RequestMapping("/subUbicacion")
@CrossOrigin(origins = "*")
public class SubUbicacionControlador {
    
    @Autowired
    SubUbicacionServicios subUbicacionServicios;

    @GetMapping("/listarSubUbicacion")
    public List<SubUbicacion> getListaSubUbicacion() {
        return subUbicacionServicios.listarSubUbicaciones();
    }

    @PostMapping("/guardarSubUbicacion")
    public ResponseEntity<Mensaje> guardarSubUbicacion(@RequestBody SubUbicacion subUbicacion) {
        try {
            subUbicacionServicios.guardarSubUbicacion(subUbicacion);
            return ResponseEntity.ok(new Mensaje("Sub Ubicacion guardada correctamente"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Mensaje("Error al guardar la Sub Ubicacion: " + e.getMessage()));
        }
    }

    @PutMapping("/actualizarSubUbicacion/{id}")
    public ResponseEntity<Mensaje> actualizarSubUbicacion(@PathVariable int id,@RequestBody SubUbicacion actualizarSubUbicacion) {

        try{
            Optional<SubUbicacion> subUbicacionOpt = subUbicacionServicios.getSubUbicacionById(id);

            if(!subUbicacionOpt.isPresent()){
                return ResponseEntity.badRequest().body(new Mensaje("La Sub Ubicacion con id " + id + " no existe"));
            }else{
                SubUbicacion subUbicacion = subUbicacionOpt.get();
                subUbicacion.setUbicacion(actualizarSubUbicacion.getUbicacion());
                subUbicacion.setNombreSubUbicacion(actualizarSubUbicacion.getNombreSubUbicacion());
                subUbicacion.setOpservacionSubUbicacion(actualizarSubUbicacion.getOpservacionSubUbicacion());
                subUbicacionServicios.guardarSubUbicacion(subUbicacion);
                return ResponseEntity.ok(new Mensaje("Sub Ubicacion actualizada correctamente"));
            }
        
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new Mensaje("Error al actualizar la Sub Ubicacion: " + e.getMessage()));
        }
    }

    @DeleteMapping("/eliminarSubUbicacion/{id}")
    public ResponseEntity<Mensaje> eliminarSubUbicacion(@PathVariable int id) {
        try {
            Optional<SubUbicacion> subUbicacionOpt = subUbicacionServicios.getSubUbicacionById(id);

            if(!subUbicacionOpt.isPresent()){
                return ResponseEntity.badRequest().body(new Mensaje("La Sub Ubicacion con id " + id + " no existe"));
            }else{
                subUbicacionServicios.eliminarSubUbicacion(id);
                return ResponseEntity.ok(new Mensaje("Sub Ubicacion eliminada correctamente"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Mensaje("Error al eliminar la Sub Ubicacion: " + e.getMessage()));
        }
    }

}
