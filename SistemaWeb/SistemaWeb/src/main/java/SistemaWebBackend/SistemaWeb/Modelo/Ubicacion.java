package SistemaWebBackend.SistemaWeb.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Ubicacion {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idUbicacion;
    private String nombreUbicacion;
    private boolean estadoUbicacion;
    
}
