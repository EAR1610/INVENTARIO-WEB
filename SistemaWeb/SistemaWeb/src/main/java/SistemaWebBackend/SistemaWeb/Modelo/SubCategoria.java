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
public class SubCategoria {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idSubCategoria;
    private String subCategoria;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idCategoria",  referencedColumnName = "idCategoria")
    private Categoria categoria;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idBodega",  referencedColumnName = "idBodega")
    private Bodega bodega;
    private boolean estadoSubCategoria;

    
}
