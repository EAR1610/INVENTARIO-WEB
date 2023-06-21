package SistemaWebBackend.SistemaWeb.Servicios;


import SistemaWebBackend.SistemaWeb.Modelo.TipoAjustes;
import SistemaWebBackend.SistemaWeb.Repositorio.TipoAjusteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TipoAjusteService {

    @Autowired
    TipoAjusteRepositorio tipoAjusteRepositorio;

    //Se listan todos los tipos de ajustes del sistema que su estado se encuentre en 'true'
    public List<TipoAjustes> listarTipoAjustes(){
        return tipoAjusteRepositorio.findAllByEstadoTipoAjustes(true);
    }

    //Se guarda un registro de tipo de ajuste
    public void guardarTipoAjuste(TipoAjustes tipoAjustes){
        tipoAjustes.setEstadoTipoAjustes(true);
        tipoAjusteRepositorio.save(tipoAjustes);
    }

    //Para 'eliminar' un registro se procede a settear el estado como 'false'
    public Optional<TipoAjustes> borrarTipoAjustes(int idTipoAjustes){
        Optional<TipoAjustes> tipoAjustes = tipoAjusteRepositorio.findById(idTipoAjustes);

        if(tipoAjustes.isPresent()){
            TipoAjustes tipoAjustesData = tipoAjustes.get();
            tipoAjustesData.setEstadoTipoAjustes(false);
            tipoAjusteRepositorio.save(tipoAjustesData);
            return Optional.of(tipoAjustesData);
        } else {
            return Optional.empty();
        }
    }

    //Obtener tipoAjuste por medio de su Id
    public Optional<TipoAjustes> gettipoAjustesById(Integer idTipoAjustes) {
        return tipoAjusteRepositorio.findById(idTipoAjustes);
    }
}
