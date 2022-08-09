package co.com.qsofkau.model.pregunta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Pregunta {
    private String id;
    private String coachId;
    private LocalDateTime fechaActualizacion;
    private String pregunta;
    private String areaConocimiento;
    private String descriptor;
    private String tipoPregunta;
    private Set<Opcion> opciones;
}
