package co.com.qsofkau.model.aspirante;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Aspirante {
    private String id;
    private String nombre;
    private String correo;
    private Integer nivel;
    private Integer puntajePrueba1;
    private Integer puntajePrueba2;
    private String codigoVerificacion;
    private String evaluacionId;

    public void asignarPuntaje(Integer puntaje) {
        if(Objects.isNull(this.puntajePrueba1) || this.puntajePrueba1 == 0){
            this.puntajePrueba1 = puntaje;
        }else if(Objects.isNull(this.puntajePrueba2) || this.puntajePrueba2 == 0){
            this.puntajePrueba2 = puntaje;
        }
    }
}
