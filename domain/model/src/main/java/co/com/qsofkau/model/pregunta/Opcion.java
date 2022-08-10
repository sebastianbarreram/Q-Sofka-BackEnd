package co.com.qsofkau.model.pregunta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Opcion {
    private String nombre;
        private Boolean esCorrecto;
}
