package co.com.qsofkau.model.usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private String id;
    private String nombre;
    private String apellido;
    private String correo;
    private String rol;
    private String usuario;
    private String contrasena;
}
