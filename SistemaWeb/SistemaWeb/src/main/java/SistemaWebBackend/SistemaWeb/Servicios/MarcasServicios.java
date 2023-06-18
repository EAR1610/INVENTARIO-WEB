package SistemaWebBackend.SistemaWeb.Servicios;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import SistemaWebBackend.SistemaWeb.Modelo.Marcas;
import SistemaWebBackend.SistemaWeb.Repositorio.MarcasRepositorio;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MarcasServicios {

    @Autowired
    MarcasRepositorio marcasRepositorio;

    // listar todos los registros de marcas
    public List<Marcas> listarMarcas() {
        return marcasRepositorio.findAllByEstadoMarca(true);
    }

    // //guardar registro de marcas
    public Marcas guardarMarca(Marcas marcas) {
    marcas.setEstadoMarca(true);

    Optional<Marcas> existenteMarca = marcasRepositorio.findByNombreMarca(marcas.getNombreMarca());
    
    if(existenteMarca.isPresent()){
    
        if(existenteMarca.get().getIdMarca() != marcas.getIdMarca()){
            throw new IllegalStateException("Ya existe una marca con el mismo nombre");
        }
    }
    
    return marcasRepositorio.save(marcas);
}

    // public Marcas guardarMarca(Marcas marcas) {
    //     marcas.setEstadoMarca(true);

    //     //Validar si existe una marca con el mismo nombre
    //     boolean existeMarca = marcasRepositorio.existsByNombreMarca(marcas.getNombreMarca());
    //     if (existeMarca) {
    //         throw new IllegalStateException("Ya existe una marca con el mismo nombre");
    //     }else{

    //         return marcasRepositorio.save(marcas);

    //     }


        
    // }
    
    //eliminar registro de marcas
    public Optional<Marcas> eliminarMarca(int idMarca) {
        Optional<Marcas> marcas = marcasRepositorio.findById(idMarca);
        if (marcas.isPresent()) {
            Marcas marcasData = marcas.get();
            marcasData.setEstadoMarca(false);
            marcasRepositorio.save(marcasData);
            return Optional.of(marcasData);
        } else {
            return Optional.empty();
        }
        
    }

    
   
    public Optional<Marcas> getMarcasById(int id){
        return marcasRepositorio.findById(id);
    }
    
    
}
