package SistemaWebBackend.SistemaWeb.Controlador;

import SistemaWebBackend.SistemaWeb.Mensaje.Mensaje;
import SistemaWebBackend.SistemaWeb.Modelo.TipoAjustes;
import SistemaWebBackend.SistemaWeb.Servicios.TipoAjusteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipoAjustes")
@CrossOrigin(origins = "*")
public class TipoAjustesController {
    @Autowired
    TipoAjusteService tipoAjusteService;

    @GetMapping("/listarTipoAjustes")
    public List<TipoAjustes> getListTipoAjustes(){
        return tipoAjusteService.listarTipoAjustes();
    }

    @PostMapping("/guardarTipoAjustes")
    public ResponseEntity<Mensaje> guardarTipoAjuste(@RequestBody TipoAjustes tipoAjustes){
        try {
            tipoAjusteService.guardarTipoAjuste(tipoAjustes);
            return ResponseEntity.ok(new Mensaje("Tipo de ajuste agregado correctamente"));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new Mensaje("Ha ocurrido un error al aguardar el tipo de ajuste"));
        }
    }

    @PutMapping("/actualizarTipoAjustes/{idTipoAjustes}")
    public ResponseEntity<?> actualizarTipoAjustes(@PathVariable int idTipoAjustes, @RequestBody TipoAjustes actualizarTipoAjustes){
        Optional<TipoAjustes> tipoAjustesOptional = tipoAjusteService.gettipoAjustesById(idTipoAjustes);
        if (!tipoAjustesOptional.isPresent()) {
            return ResponseEntity.badRequest().body(new Mensaje("El tipoAjuste con id " + idTipoAjustes + " no existe"));
        }
        try {
            TipoAjustes tipoAjustes = tipoAjustesOptional.get();
            tipoAjustes.setNombre(actualizarTipoAjustes.getNombre());
            tipoAjustes.setTipo(actualizarTipoAjustes.isTipo());
            tipoAjusteService.guardarTipoAjuste(tipoAjustes);

            return ResponseEntity.ok(new Mensaje("Tipo de ajustes actualizada correctamente"));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new Mensaje("Error al actualizar el tipo de ajustes"));
        }
    }

    @DeleteMapping("/eliminarTipoAjustes/{idTipoAjustes}")
    public ResponseEntity<Mensaje> borrarTipoAjustes(@PathVariable int idTipoAjustes){
        try {
            Optional<TipoAjustes> tipoAjuste = tipoAjusteService.borrarTipoAjustes(idTipoAjustes);
            if (tipoAjuste.isPresent()){
               return ResponseEntity.ok(new Mensaje("TipoAjuste eliminada correctamente"));
            } else {
                return ResponseEntity.badRequest().body(new Mensaje("Error al eliminar el tipoAjuste"));
            }

        } catch (Exception e){
            return ResponseEntity.badRequest().body(new Mensaje("Error al eliminar el tipoAjuste: " + e.getMessage()));
        }
    }
}
