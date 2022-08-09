package co.com.qsofkau.model.areaconocimiento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Descriptor {
    private String idDescriptor;
    private String nombre;
}
