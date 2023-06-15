package SistemaWebBackend.SistemaWeb.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import SistemaWebBackend.SistemaWeb.Modelo.SubCategoria;
import SistemaWebBackend.SistemaWeb.Repositorio.SubCategoriaRepositorio;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SubCategoriaServicios {

    @Autowired
    SubCategoriaRepositorio subCategoriaRepositorio;

    // listar todos los registros de subcategoria
    public List<SubCategoria> listarSubCategorias() {
        return subCategoriaRepositorio.findAllByEstadoSubCategoria(true);
    }

    // guardar un registro de subcategoria
    public void guardarSubCategoria(SubCategoria subCategoria) {
        subCategoria.setEstadoSubCategoria(true);
        subCategoriaRepositorio.save(subCategoria);
    }

    // eliminar un registro de subcategoria pasaremos su estado a false
    public Optional<SubCategoria> borrarSubCategoria(int idSubCategoria){
        Optional<SubCategoria> subCategoria = subCategoriaRepositorio.findById(idSubCategoria);
        if(subCategoria.isPresent()){
            SubCategoria subCategoriaData = subCategoria.get();
            subCategoriaData.setEstadoSubCategoria(false);
            subCategoriaRepositorio.save(subCategoriaData);
            return Optional.of(subCategoriaData);
        }else{
            return Optional.empty();
        }
    }

     public Optional<SubCategoria> getSubCategoriaById(Integer id) {
        return subCategoriaRepositorio.findById(id);
    }

    
}
