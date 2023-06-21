package SistemaWebBackend.SistemaWeb.Repositorio;

import java.util.Optional;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SistemaWebBackend.SistemaWeb.Modelo.ArticuloBodega;

@Repository
public interface ArticuloBodegaRepositorio extends JpaRepository<ArticuloBodega, Integer> {

    Optional<ArticuloBodega> findByCodigoArticulo(int codigoArticulo);

    Optional<ArticuloBodega> findByEstadoArticuloBodega(boolean estadoArticuloBodega);

    Optional<ArticuloBodega> findByIdArticuloBodega(int idArticuloBodega);

    List<ArticuloBodega> findAllByEstadoArticuloBodega(boolean estadoArticuloBodega);
    
}
