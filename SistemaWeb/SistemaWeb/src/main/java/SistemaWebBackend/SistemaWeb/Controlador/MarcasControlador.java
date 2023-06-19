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
import SistemaWebBackend.SistemaWeb.Modelo.Marcas;
import SistemaWebBackend.SistemaWeb.Servicios.MarcasServicios;

@RestController
@RequestMapping("/marcas")
@CrossOrigin(origins = "*")
public class MarcasControlador {

    @Autowired
    MarcasServicios marcasServicios;

    @GetMapping("/listarMarcas")
    public List<Marcas> getListaMarcas() {
        return marcasServicios.listarMarcas();
    }

    @PostMapping("/guardarMarca")
    public ResponseEntity<Mensaje> guardarMarca(@RequestBody Marcas marca) {
        try {
            marcasServicios.guardarMarca(marca);
            return ResponseEntity.ok(new Mensaje("Marca guardada correctamente"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Mensaje("Error al guardar la Marca: " + e.getMessage()));
        }
    }

    @PutMapping("/actualizarMarca/{id}")
    public ResponseEntity<Mensaje> actualizarMarca(@PathVariable int id,@RequestBody Marcas nuevaMarca) {
        try {
           Optional<Marcas> marcasOpt = marcasServicios.getMarcasById(id);
              if(!marcasOpt.isPresent()){
                return ResponseEntity.badRequest().body(new Mensaje("La Marca con id " + id + " no existe"));
              }else{
                 Marcas marcas = marcasOpt.get();
                 marcas.setNombreMarca(nuevaMarca.getNombreMarca());
                 //marcas.setBodega(nuevaMarca.getBodega());
                 marcasServicios.guardarMarca(marcas);
                return ResponseEntity.ok(new Mensaje("Marca actualizada correctamente"));

             }
              
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Mensaje("Error al actualizar la Marca: "+ nuevaMarca.getNombreMarca() + e.getMessage()));
        }
    }

    @DeleteMapping("/eliminarMarca/{id}")
    public ResponseEntity<Mensaje> eliminarMarca(@PathVariable int id) {
        try {
            Optional<Marcas> marcasOpt = marcasServicios.eliminarMarca(id);
            if(!marcasOpt.isPresent()){
                return ResponseEntity.badRequest().body(new Mensaje("La Marca con id " + id + " no existe"));
            }else{
                return ResponseEntity.ok(new Mensaje("Marca eliminada correctamente"));
            }
        
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Mensaje("Error al eliminar la Marca: " + e.getMessage()));
        }
    }

    
    
}
