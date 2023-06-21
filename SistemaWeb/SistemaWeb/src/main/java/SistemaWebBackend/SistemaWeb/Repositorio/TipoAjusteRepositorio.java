package SistemaWebBackend.SistemaWeb.Repositorio;

import SistemaWebBackend.SistemaWeb.Modelo.TipoAjustes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoAjusteRepositorio extends JpaRepository<TipoAjustes, Integer> {
    Optional<TipoAjustes> findByEstadoTipoAjustes (boolean estadoTipoAjustes);
    List<TipoAjustes> findAllByEstadoTipoAjustes (boolean estadoTipoAjustes);
    Optional<TipoAjustes> findByIdTipoAjustes(Integer idTipoAjustes);
}
