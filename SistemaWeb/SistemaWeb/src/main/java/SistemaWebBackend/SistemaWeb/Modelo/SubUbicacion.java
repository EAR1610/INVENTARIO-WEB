package SistemaWebBackend.SistemaWeb.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class SubUbicacion {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idSubUbicacion;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idUbicacion",  referencedColumnName = "idUbicacion")
    private Ubicacion ubicacion;
    private String nombreSubUbicacion;
    private String opservacionSubUbicacion;
    private boolean estadoSubUbicacion;
    
}
