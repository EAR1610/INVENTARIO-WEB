package SistemaWebBackend.SistemaWeb.Servicios;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SistemaWebBackend.SistemaWeb.Modelo.ArticuloBodega;
import SistemaWebBackend.SistemaWeb.Repositorio.ArticuloBodegaRepositorio;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ArticuloBodegaServicios {

    @Autowired
    ArticuloBodegaRepositorio articuloBodegaRepositorio;

    public List<ArticuloBodega> listarArticulosBodega() {
        return articuloBodegaRepositorio.findAllByEstadoArticuloBodega(true);
    }

    public void guardarArticuloBodega(ArticuloBodega articuloBodega) {
        articuloBodega.setEstadoArticuloBodega(true);
        articuloBodegaRepositorio.save(articuloBodega);
    }

    public Optional<ArticuloBodega> borrarArticuloBodega(int idArticuloBodega) {
        Optional<ArticuloBodega> articuloBodega = articuloBodegaRepositorio.findById(idArticuloBodega);
        if (articuloBodega.isPresent()) {
            ArticuloBodega articuloBodegaData = articuloBodega.get();
            articuloBodegaData.setEstadoArticuloBodega(false);
            articuloBodegaRepositorio.save(articuloBodegaData);
            return Optional.of(articuloBodegaData);
        } else {
            return Optional.empty();
        }
    }
    
}
