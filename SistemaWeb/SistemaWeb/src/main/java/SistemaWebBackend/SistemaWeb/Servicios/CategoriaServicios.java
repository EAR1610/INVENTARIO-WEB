package SistemaWebBackend.SistemaWeb.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SistemaWebBackend.SistemaWeb.Modelo.Categoria;
import SistemaWebBackend.SistemaWeb.Repositorio.CategoriaRepositorio;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoriaServicios {

    @Autowired
    CategoriaRepositorio categoriaRepositorio;

    
    // listar todos los registros de categoria
    public List<Categoria> listarCategorias() {
        return categoriaRepositorio.findAllByEstadoCategoria(true);
    }

    // guardar un registro de categoria
    public void guardarCategoria(Categoria categoria) {
        categoria.setEstadoCategoria(true);
        categoriaRepositorio.save(categoria);
    }

    // borrar un registro de categoria solo pasaremos el estado a false
    public Optional<Categoria> borrarCategoria(int idCategoria) {
        Optional<Categoria> categoria = categoriaRepositorio.findById(idCategoria);
        if (categoria.isPresent()) {
            Categoria categoriaData = categoria.get();
            categoriaData.setEstadoCategoria(false);
            categoriaRepositorio.save(categoriaData);
            return Optional.of(categoriaData);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Categoria> getCategoriaById(Integer id) {
        return categoriaRepositorio.findById(id);
    }

}