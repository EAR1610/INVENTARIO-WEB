package SistemaWebBackend.SistemaWeb.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SistemaWebBackend.SistemaWeb.Modelo.SubUbicacion;

@Repository
public interface SubUbicacionRepositorio extends JpaRepository<SubUbicacion, Integer> {

    Optional<SubUbicacion> findByEstadoSubUbicacion(boolean estadoSubUbicacion);

    Optional<SubUbicacion> findById(Integer id);

    List<SubUbicacion> findAllByEstadoSubUbicacion(boolean estadoSubUbicacion);
    
}
