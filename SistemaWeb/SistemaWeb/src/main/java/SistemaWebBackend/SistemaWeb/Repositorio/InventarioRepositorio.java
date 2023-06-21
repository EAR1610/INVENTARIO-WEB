package SistemaWebBackend.SistemaWeb.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SistemaWebBackend.SistemaWeb.Modelo.Inventario;

@Repository
public interface InventarioRepositorio extends JpaRepository<Inventario, Integer> {

    Optional<Inventario> findByEstadoInventario(boolean estadoInventario);

    Optional<Inventario> findById(Integer id);

    List<Inventario> findAllByEstadoInventario(boolean estadoInventario);
    
    
}
