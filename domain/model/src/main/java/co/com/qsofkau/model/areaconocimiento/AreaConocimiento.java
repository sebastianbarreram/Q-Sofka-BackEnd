package co.com.qsofkau.model.areaconocimiento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AreaConocimiento {
    private String id;
    private String nombreAreaConocimiento;
    private List<Descriptor> descriptores;
}
