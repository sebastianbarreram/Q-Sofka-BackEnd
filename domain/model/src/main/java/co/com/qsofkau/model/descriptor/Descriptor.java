package co.com.qsofkau.model.descriptor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Descriptor {

    private String id;
    private String idAreaConocimiento;
}
