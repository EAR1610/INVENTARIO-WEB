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
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInventario;
    private boolean productoCompuesto;
    private float consignado;
    private boolean lote;
    private int casaComercial;
    private String codigoFabrcante;
    private String nombreGenerico;
    private String imagen;
    private float cantidadMayoreo;
    private boolean facturable;
    private float paquetePorFardo;
    private float precioPorFardo;
    private boolean estadoInventario;
}
