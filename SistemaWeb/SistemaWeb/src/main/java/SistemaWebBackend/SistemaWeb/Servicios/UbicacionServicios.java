package SistemaWebBackend.SistemaWeb.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SistemaWebBackend.SistemaWeb.Modelo.Ubicacion;
import SistemaWebBackend.SistemaWeb.Repositorio.UbicacionRepositorio;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UbicacionServicios {

    @Autowired
    UbicacionRepositorio ubicacionRepositorio;

    // listar todos los registros de ubicacion
    public List<Ubicacion> listarUbicaciones() {
        return ubicacionRepositorio.findAllByEstadoUbicacion(true);
    }

    // guardar un registro de ubicacion
    public void guardarUbicacion(Ubicacion ubicacion) {
        ubicacion.setEstadoUbicacion(true);
        ubicacionRepositorio.save(ubicacion);
    }

    // eliminar un registro de ubicacion pasaremos su estado a false
    public Optional<Ubicacion> eliminarUbicacion(int idUbicacion){
        Optional<Ubicacion> ubicacion = ubicacionRepositorio.findById(idUbicacion);
        if(ubicacion.isPresent()){
            Ubicacion ubicacionData = ubicacion.get();
            ubicacionData.setEstadoUbicacion(false);
            ubicacionRepositorio.save(ubicacionData);
            return Optional.of(ubicacionData);
        }else{
            return Optional.empty();
        }
    }

     public Optional<Ubicacion> getUbicacionById(Integer id) {
        return ubicacionRepositorio.findById(id);
    }


    
}
