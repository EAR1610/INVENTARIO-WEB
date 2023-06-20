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
import SistemaWebBackend.SistemaWeb.Modelo.Ubicacion;
import SistemaWebBackend.SistemaWeb.Servicios.UbicacionServicios;

@RestController
@RequestMapping("/ubicacion")
@CrossOrigin(origins = "*")
public class UbicacionControlador {

    @Autowired
    UbicacionServicios ubicacionServicios;

    @GetMapping("/listarUbicaciones")
    public List<Ubicacion> listarUbicaciones() {
        return ubicacionServicios.listarUbicaciones();
    }

    @PostMapping("/guardarUbicacion")
    public ResponseEntity<Mensaje> guardarUbicacion(@RequestBody Ubicacion ubicacion) {
    try {
        ubicacionServicios.guardarUbicacion(ubicacion);
        return ResponseEntity.ok(new Mensaje("Ubicacion creada correctamente"));
    } catch (Exception e) {
        return ResponseEntity.badRequest().body(new Mensaje("Error al crear la ubicacion"));
    }
  }
    
    @PutMapping("/actualizarUbicacion/{id}")
    public ResponseEntity<Mensaje> actualizarUbicacion(@PathVariable int id,@RequestBody Ubicacion actualizarUbicacion) {
        try {
            Optional<Ubicacion> ubicacionOpt = ubicacionServicios.getUbicacionById(id);
            if(!ubicacionOpt.isPresent()){
                return ResponseEntity.badRequest().body(new Mensaje("La ubicacion con id " + id + " no existe"));
            }else{
                Ubicacion ubicacion = ubicacionOpt.get();
                ubicacion.setNombreUbicacion(actualizarUbicacion.getNombreUbicacion());

                ubicacionServicios.guardarUbicacion(ubicacion);
                return ResponseEntity.ok(new Mensaje("Ubicacion actualizada correctamente "+ubicacion.getNombreUbicacion()));
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Mensaje("Error al actualizar la ubicacion"));
        }
    }

    @DeleteMapping("/eliminarUbicacion/{id}")
    public ResponseEntity<Mensaje> eliminarUbicacion(@PathVariable int id) {
        try {
            Optional<Ubicacion> ubicacionOpt = ubicacionServicios.getUbicacionById(id);
            if(!ubicacionOpt.isPresent()){
                return ResponseEntity.badRequest().body(new Mensaje("La ubicacion con id " + id + " no existe"));
            }else{
                ubicacionServicios.eliminarUbicacion(id);
                return ResponseEntity.ok(new Mensaje("Ubicacion eliminada correctamente"));
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Mensaje("Error al eliminar la ubicacion"));
        }
    }


    
    
}
