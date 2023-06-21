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
public class TipoAjustes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoAjustes;
    private String nombre;
    private boolean tipo;
    private boolean estadoTipoAjustes;
}
