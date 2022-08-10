package co.com.qsofkau.model.aspirante;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
