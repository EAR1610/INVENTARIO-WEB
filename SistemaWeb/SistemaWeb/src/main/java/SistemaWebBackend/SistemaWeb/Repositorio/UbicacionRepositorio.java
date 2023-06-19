package SistemaWebBackend.SistemaWeb.Repositorio;

import java.util.List;
import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SistemaWebBackend.SistemaWeb.Modelo.Ubicacion;

@Repository
public interface UbicacionRepositorio extends JpaRepository<Ubicacion, Integer> {
    
    Optional<Ubicacion> findByEstadoUbicacion(boolean estadoUbicacion);

    Optional<Ubicacion> findById(Integer id);

    List<Ubicacion> findAllByEstadoUbicacion(boolean estadoUbicacion);
    
}
