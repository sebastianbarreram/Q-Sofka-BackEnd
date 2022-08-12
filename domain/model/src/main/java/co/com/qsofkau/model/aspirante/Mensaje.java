package co.com.qsofkau.model.aspirante;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Mensaje {

    private String nombre;
    private Integer valoracion;
    private String fase;

}
