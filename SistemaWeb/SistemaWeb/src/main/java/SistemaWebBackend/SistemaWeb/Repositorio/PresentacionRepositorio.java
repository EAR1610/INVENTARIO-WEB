package SistemaWebBackend.SistemaWeb.Repositorio;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SistemaWebBackend.SistemaWeb.Modelo.Presentacion;

@Repository
public interface PresentacionRepositorio extends JpaRepository<Presentacion, Integer> {

    Optional<Presentacion> findByEstadoPresentacion(boolean estadoPresentacion);

    Optional<Presentacion> findById(Integer id);

    List<Presentacion> findAllByEstadoPresentacion(boolean estadoPresentacion);
    
}
