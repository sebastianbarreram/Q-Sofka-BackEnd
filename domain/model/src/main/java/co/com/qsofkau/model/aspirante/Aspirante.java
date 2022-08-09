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
    private String valoracion;
    private String codigoVerificacion;
}
