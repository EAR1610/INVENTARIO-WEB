package SistemaWebBackend.SistemaWeb.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SistemaWebBackend.SistemaWeb.Modelo.Bodega;

@Repository
public interface BodegaRepositorio extends JpaRepository<Bodega, Integer> {

    //para eliminar un registro de bodega solo pasaremos el estado a false
    Optional<Bodega> findByEstadoBodega(boolean estadoBodega);

    //listaremos solo el listado de bodegas con estado true
    List<Bodega> findAllByEstadoBodega(boolean estadoBodega);


    

    
}
