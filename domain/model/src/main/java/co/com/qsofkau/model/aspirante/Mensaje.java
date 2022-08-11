package co.com.qsofkau.model.aspirante;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Mensaje {

    private String nombre;
    private Integer valoracion;
    private String fase;

}
