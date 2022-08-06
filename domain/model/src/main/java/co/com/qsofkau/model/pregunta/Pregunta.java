package co.com.qsofkau.model.pregunta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Pregunta {
    private String id;
    private String coachId;
    private String fecha;
    private String nombrePregunta;
    private String areaConocimiento;
    private String tipoPregunta;
    private Set<Opcion> opciones;
}
