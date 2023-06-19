package SistemaWebBackend.SistemaWeb.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
}
