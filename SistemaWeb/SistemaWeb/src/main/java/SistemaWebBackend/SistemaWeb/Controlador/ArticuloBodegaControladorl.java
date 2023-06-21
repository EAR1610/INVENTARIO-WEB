package SistemaWebBackend.SistemaWeb.Controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    
    
    
}
