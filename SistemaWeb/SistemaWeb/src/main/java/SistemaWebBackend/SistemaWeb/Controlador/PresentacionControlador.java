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
import SistemaWebBackend.SistemaWeb.Modelo.Presentacion;
import SistemaWebBackend.SistemaWeb.Servicios.PresentacionServicios;

@RestController
@RequestMapping("/presentacion")
@CrossOrigin(origins = "*")
public class PresentacionControlador {

    @Autowired
    PresentacionServicios presentacionServicios;

    @GetMapping("/listarPresentaciones")
    public List<Presentacion> listarPresentaciones() {
        return presentacionServicios.listarPresentaciones();
    }

    @PostMapping("/guardarPresentacion")
    public ResponseEntity<Mensaje> crearPresentacion(@RequestBody Presentacion presentacion) {
        try {
            presentacionServicios.guardarPresentacion(presentacion);
            return ResponseEntity.ok(new Mensaje("Presentacion creada correctamente"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Mensaje("Error al crear la presentacion"));
        }
    }

    @PutMapping("/actualizarPresentacion/{id}")
    public ResponseEntity<?> actualizarPresentacion(@PathVariable int id,@RequestBody Presentacion actualizarPresentacion) {
        try {
            Optional<Presentacion> presentacionOpt = presentacionServicios.obtenerPorId(id);
            if (!presentacionOpt.isPresent()) {
                return ResponseEntity.badRequest().body(new Mensaje("Error: la presentacion no existe"));
            }
            Presentacion presentacion = presentacionOpt.get();
            presentacion.setNombrePresentacion(actualizarPresentacion.getNombrePresentacion());
            presentacionServicios.guardarPresentacion(presentacion);
           
            return ResponseEntity.ok(new Mensaje("Presentacion actualizada correctamente"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Mensaje("Error al actualizar la presentacion"));
        }
    }

    @DeleteMapping("/eliminarPresentacion/{id}")
    public ResponseEntity<Mensaje> eliminarPresentacion(@PathVariable int id) {
        try {
            Optional <Presentacion> presentacion = presentacionServicios.borrarPresentacion(id);
            if (!presentacion.isPresent()) {
                return ResponseEntity.badRequest().body(new Mensaje("Error: la presentacion no existe"));
            }else{
                return ResponseEntity.ok(new Mensaje("Presentacion eliminada correctamente"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Mensaje("Error al eliminar la presentacion"));
        }
    }
    
}
