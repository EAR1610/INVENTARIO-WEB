package SistemaWebBackend.SistemaWeb.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SistemaWebBackend.SistemaWeb.Modelo.Presentacion;
import SistemaWebBackend.SistemaWeb.Repositorio.PresentacionRepositorio;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PresentacionServicios {

    @Autowired
    PresentacionRepositorio presentacionRepositorio;

    public List<Presentacion> listarPresentaciones() {
        return presentacionRepositorio.findAllByEstadoPresentacion(true);
    }

    public void guardarPresentacion(Presentacion presentacion) {
        presentacion.setEstadoPresentacion(true);
        presentacionRepositorio.save(presentacion);
    }

    public Optional<Presentacion> borrarPresentacion(int idPresentacion) {
        Optional<Presentacion> presentacion = presentacionRepositorio.findById(idPresentacion);
        if (presentacion.isPresent()) {
            Presentacion presentacionData = presentacion.get();
            presentacionData.setEstadoPresentacion(false);
            presentacionRepositorio.save(presentacionData);
            return Optional.of(presentacionData);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Presentacion> obtenerPorId(int idPresentacion) {
        return presentacionRepositorio.findById(idPresentacion);
    }
    
}
