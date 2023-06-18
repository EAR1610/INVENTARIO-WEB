package SistemaWebBackend.SistemaWeb.Repositorio;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SistemaWebBackend.SistemaWeb.Modelo.Marcas;

@Repository
public interface MarcasRepositorio extends JpaRepository<Marcas, Integer> {

    Optional<Marcas> findByEstadoMarca(boolean estadoMarca);

    List<Marcas> findAllByEstadoMarca(boolean estadoMarca);

    Optional<Marcas> findById(Integer id);

    //Validar si existe una marca con el mismo nombre
    boolean existsByNombreMarca(String nombreMarca);

    Optional<Marcas> findByNombreMarca(String nombreMarca);
    
    
}
