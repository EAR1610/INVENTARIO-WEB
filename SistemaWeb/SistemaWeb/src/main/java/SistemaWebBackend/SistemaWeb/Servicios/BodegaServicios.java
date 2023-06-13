package SistemaWebBackend.SistemaWeb.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SistemaWebBackend.SistemaWeb.Modelo.Bodega;
import SistemaWebBackend.SistemaWeb.Repositorio.BodegaRepositorio;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class BodegaServicios {

    @Autowired
    BodegaRepositorio bodegaRepositorio;

    //listar todos los registros de bodega
   public List<Bodega> listarBodegas(){
    return bodegaRepositorio.findAllByEstadoBodega(true);
  }


    
    //guardar un registro de bodega
    public void guardarBodega(Bodega bodega){
        bodega.setEstadoBodega(true);
        bodegaRepositorio.save(bodega);
    }

    //borrar un registro de bodega solo pasaremos el estado a false
    public Optional<Bodega> borrarBodega(int idBodega) {
    Optional<Bodega> bodega = bodegaRepositorio.findById(idBodega);
    if (bodega.isPresent()) {
        Bodega bodegaData = bodega.get();
        bodegaData.setEstadoBodega(false);
        bodegaRepositorio.save(bodegaData);
        return Optional.of(bodegaData);
    } else {
        return Optional.empty();
    }
   }

    

    
}
