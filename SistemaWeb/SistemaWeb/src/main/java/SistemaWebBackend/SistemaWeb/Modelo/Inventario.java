package SistemaWebBackend.SistemaWeb.Modelo;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idInventario;
    private String barras;
    private String descripcion;
    private String descripcionCorta;
    private Float  presentacion;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idPresentacion",  referencedColumnName = "idPresentacion")
    private Presentacion presentacionCodigo;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idMarca",  referencedColumnName = "idMarca")
    private Marcas marcas;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idSubCategoria",  referencedColumnName = "idSubCategoria")
    private SubCategoria subCategoria;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idSubUbicacion",  referencedColumnName = "idSubUbicacion")
    private SubUbicacion subUbicacion;
    private Float  minima;
    private Float  maxima;
    private Float  existencia;
    private String Observaciones;
    private BigDecimal costoGeneral;
    private Boolean idVenta;
    private BigDecimal precioA;
    private BigDecimal precioB;
    private BigDecimal precioC;
    private BigDecimal precioD;
    private boolean permiteDescuento;
    private float maxDesc;
    private ZonedDateTime fechaIngreso;
    private boolean preguntaPrecio;
    private float apartado;
    private boolean inhabilitado;
    private boolean servicio;
    private boolean serie;
    private float porComision;
    private boolean productoCompuesto;
    private float consignado;
    private boolean estadoInventario;
 
}
