package SistemaWebBackend.SistemaWeb.Servicios;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SistemaWebBackend.SistemaWeb.Modelo.SubUbicacion;
import SistemaWebBackend.SistemaWeb.Repositorio.SubUbicacionRepositorio;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SubUbicacionServicios {

    @Autowired
    SubUbicacionRepositorio subUbicacionRepositorio;
    
    public List<SubUbicacion> listarSubUbicaciones() {
        return subUbicacionRepositorio.findAllByEstadoSubUbicacion(true);
    }

    public void guardarSubUbicacion(SubUbicacion subUbicacion) {
        subUbicacion.setEstadoSubUbicacion(true);
        subUbicacionRepositorio.save(subUbicacion);
    }

    public Optional<SubUbicacion> eliminarSubUbicacion(int idSubUbicacion){
        Optional<SubUbicacion> subUbicacion = subUbicacionRepositorio.findById(idSubUbicacion);
        if(subUbicacion.isPresent()){
            SubUbicacion subUbicacionData = subUbicacion.get();
            subUbicacionData.setEstadoSubUbicacion(false);
            subUbicacionRepositorio.save(subUbicacionData);
            return Optional.of(subUbicacionData);
        }else{
            return Optional.empty();
        }
    }

    public Optional<SubUbicacion> getSubUbicacionById(Integer id) {
        return subUbicacionRepositorio.findById(id);
    }
}
