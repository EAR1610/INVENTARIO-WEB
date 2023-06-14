package SistemaWebBackend.SistemaWeb.Repositorio;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SistemaWebBackend.SistemaWeb.Modelo.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {

    Optional<Categoria> findByEstadoCategoria(boolean estadoCategoria);

    List<Categoria> findAllByEstadoCategoria(boolean estadoCategoria);

    Optional<Categoria> findById(Integer id);
    
}
