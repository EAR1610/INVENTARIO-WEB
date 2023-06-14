package SistemaWebBackend.SistemaWeb.Modelo;

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
public class Categoria {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idCategoria;
    private String nombreCategoria;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idBodega",  referencedColumnName = "idBodega")
    private Bodega bodega;
    private boolean estadoCategoria;

    public Categoria(String nombreCategoria, Bodega bodega, boolean estadoCategoria) {
        this.nombreCategoria = nombreCategoria;
        this.bodega = bodega;
        this.estadoCategoria = estadoCategoria;
    }

    

    
}
