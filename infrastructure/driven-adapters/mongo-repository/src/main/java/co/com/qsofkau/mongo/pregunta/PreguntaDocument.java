package co.com.qsofkau.mongo.pregunta;

import co.com.qsofkau.model.pregunta.Opcion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@Data
public class PreguntaDocument {

    @Id
    private String id;
    private String coachId;
    private String fecha;
    private String pregunta;
    private String areaConocimiento;
    private String tipoPregunta;
    private Set<Opcion> opciones;
}
