package co.com.qsofkau.mongo.pregunta;

import co.com.qsofkau.model.pregunta.Opcion;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Set;

@Document
@Data
public class PreguntaDocument {

    @Id
    private String id;
    private String coachId;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private String pregunta;
    private String areaConocimiento;
    private String descriptor;
    private String tipoPregunta;
    private Set<Opcion> opciones;
}
