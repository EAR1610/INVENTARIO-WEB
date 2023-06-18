package SistemaWebBackend.SistemaWeb.Modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bodega {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idBodega;
    private String nombreBodega;
    private String observacionBodega;
    private boolean principalBodega;
    private String imagenBodega;
    private boolean estadoBodega;
}
