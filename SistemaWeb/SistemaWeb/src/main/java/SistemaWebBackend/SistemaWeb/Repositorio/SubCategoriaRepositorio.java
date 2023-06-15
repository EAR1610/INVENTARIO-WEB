package SistemaWebBackend.SistemaWeb.Repositorio;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SistemaWebBackend.SistemaWeb.Modelo.SubCategoria;

@Repository
public interface SubCategoriaRepositorio extends JpaRepository<SubCategoria, Integer> {

    Optional<SubCategoria> findByEstadoSubCategoria(boolean estadoSubCategoria);

    List<SubCategoria> findAllByEstadoSubCategoria(boolean estadoSubCategoria);

    Optional<SubCategoria> findById(Integer id);
    
}
