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
public class Presentacion {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idPresentacion;
    private String nombrePresentacion;
    private boolean estadoPresentacion;
    
}
