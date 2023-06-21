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
import SistemaWebBackend.SistemaWeb.Modelo.Inventario;
import SistemaWebBackend.SistemaWeb.Servicios.InventarioServicios;

@RestController
@RequestMapping("/inventario")
@CrossOrigin(origins = "*")
public class InventarioControlador {

    @Autowired
    InventarioServicios inventarioServicios;

    @GetMapping("/listarInventario")
    public List<Inventario> getListaInventario() {
        return inventarioServicios.listarInventario();
    }

    @PostMapping("/guardarInventario")
    public ResponseEntity<Mensaje> guardarInventario(@RequestBody Inventario inventario) {
        try {
            inventarioServicios.guardarInventario(inventario);
            return ResponseEntity.ok(new Mensaje("Inventario creado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Mensaje("Error al crear el inventario"));
        }
    }

    @PutMapping("/actualizarInventario/{id}")
    public ResponseEntity<Mensaje> actualizarInventario(@PathVariable int id, @RequestBody Inventario actualizarInventario) {
        try {
            Optional<Inventario> inventarioOpt = inventarioServicios.obtenerPorId(id);
            if(!inventarioOpt.isPresent()){
                return ResponseEntity.badRequest().body(new Mensaje("Error: El inventario no existe"));
            } else {
                Inventario inventario = inventarioOpt.get();

                // Aquí actualizamos los campos necesarios del inventario.
                inventario.setBarras(actualizarInventario.getBarras());
                inventario.setDescripcion(actualizarInventario.getDescripcion());
                inventario.setDescripcionCorta(actualizarInventario.getDescripcionCorta());
                inventario.setPresentacion(actualizarInventario.getPresentacion());
                inventario.setPresentacionCodigo(actualizarInventario.getPresentacionCodigo());
                inventario.setMarcas(actualizarInventario.getMarcas());
                inventario.setSubCategoria(actualizarInventario.getSubCategoria());
                inventario.setSubUbicacion(actualizarInventario.getSubUbicacion());
                inventario.setMinima(actualizarInventario.getMinima());
                inventario.setMaxima(actualizarInventario.getMaxima());
                inventario.setExistencia(actualizarInventario.getExistencia());
                inventario.setObservaciones(actualizarInventario.getObservaciones());
                inventario.setCostoGeneral(actualizarInventario.getCostoGeneral());
                inventario.setIdVenta(actualizarInventario.getIdVenta());
                inventario.setPrecioA(actualizarInventario.getPrecioA());
                inventario.setPrecioB(actualizarInventario.getPrecioB());
                inventario.setPrecioC(actualizarInventario.getPrecioC());
                inventario.setPrecioD(actualizarInventario.getPrecioD());
                inventario.setPermiteDescuento(actualizarInventario.isPermiteDescuento());
                inventario.setMaxDesc(actualizarInventario.getMaxDesc());
                inventario.setFechaIngreso(actualizarInventario.getFechaIngreso());
                inventario.setPreguntaPrecio(actualizarInventario.isPreguntaPrecio());
                inventario.setApartado(actualizarInventario.getApartado());
                inventario.setInhabilitado(actualizarInventario.isInhabilitado());
                inventario.setServicio(actualizarInventario.isServicio());
                inventario.setSerie(actualizarInventario.isSerie());
                inventario.setPorComision(actualizarInventario.getPorComision());
                inventario.setProductoCompuesto(actualizarInventario.isProductoCompuesto());
                inventario.setConsignado(actualizarInventario.getConsignado());

                inventarioServicios.guardarInventario(inventario);

                return ResponseEntity.ok(new Mensaje("Inventario actualizado correctamente"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Mensaje("Error al actualizar el inventario"));
        }
    }

    @DeleteMapping("/eliminarInventario/{id}")
    public ResponseEntity<Mensaje> eliminarInventario(@PathVariable int id) {
        try {
            Optional<Inventario> inventarioOpt = inventarioServicios.obtenerPorId(id);
            if(!inventarioOpt.isPresent()){
                return ResponseEntity.badRequest().body(new Mensaje("Error: El inventario no existe"));
            } else {
                inventarioServicios.eliminarInventario(id);
                return ResponseEntity.ok(new Mensaje("Inventario eliminado correctamente"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Mensaje("Error al eliminar el inventario"));
        }
    }
        
    
    
}
