package SistemaWebBackend.SistemaWeb.Controlador;

import SistemaWebBackend.SistemaWeb.Mensaje.Mensaje;
import SistemaWebBackend.SistemaWeb.Modelo.TipoAjustes;
import SistemaWebBackend.SistemaWeb.Servicios.TipoAjusteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/actualizarTipoAjustes/{id}")
    public ResponseEntity<?> actualizarTipoAjustes(@PathVariable int idTipoAjustes, @RequestBody TipoAjustes tipoAjustes){
        try {
            tipoAjustes.setNombre(tipoAjustes.getNombre());
            tipoAjustes.setTipo(tipoAjustes.isTipo());
            tipoAjusteService.guardarTipoAjuste(tipoAjustes);
            return ResponseEntity.ok(new Mensaje("Tipo de ajustes actualizada correctamente"));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new Mensaje("Error al actualizar el tipo de ajustes"));
        }
    }
}
