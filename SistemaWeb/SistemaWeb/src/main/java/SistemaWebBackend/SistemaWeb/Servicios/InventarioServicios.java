package SistemaWebBackend.SistemaWeb.Servicios;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SistemaWebBackend.SistemaWeb.Modelo.Inventario;
import SistemaWebBackend.SistemaWeb.Repositorio.InventarioRepositorio;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class InventarioServicios {

    @Autowired
    InventarioRepositorio inventarioRepositorio;

    public List<Inventario> listarInventario() {
        return inventarioRepositorio.findAllByEstadoInventario(true);
    }

    public Inventario guardarInventario(Inventario inventario) {
        inventario.setEstadoInventario(true);
        return inventarioRepositorio.save(inventario);
    }

    public Optional<Inventario> obtenerPorId(int idInventario) {
        return inventarioRepositorio.findById(idInventario);
    }

    public Optional<Inventario> eliminarInventario(int idInventario) {
        Optional<Inventario> inventario = inventarioRepositorio.findById(idInventario);
        if (inventario.isPresent()) {
            Inventario inventarioData = inventario.get();
            inventarioData.setEstadoInventario(false);
            inventarioRepositorio.save(inventarioData);
            return Optional.of(inventarioData);
        } else {
            return Optional.empty();
        }
    }
    
}
