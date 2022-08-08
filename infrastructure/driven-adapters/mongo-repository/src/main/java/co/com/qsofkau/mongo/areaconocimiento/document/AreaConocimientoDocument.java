package co.com.qsofkau.mongo.areaconocimiento.document;

import co.com.qsofkau.model.descriptor.Descriptor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@NoArgsConstructor
public class AreaConocimientoDocument {
    @Id
    private String id;
    private String nombreAreaConocimiento;
    private List<Descriptor> descriptores;
    
}
