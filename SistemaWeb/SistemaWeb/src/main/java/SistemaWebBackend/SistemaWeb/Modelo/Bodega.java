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
    private String nombreBodega;//si
    private String observacionBodega;//si
    private boolean principalBodega;//si
    //private String imagenBodega;//no
    private boolean estadoBodega;
}
