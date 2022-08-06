package co.com.qsofkau.mongo.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDocument {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String correo;
    private String rol;
    private String usuario;
    private String contrasena;
}
