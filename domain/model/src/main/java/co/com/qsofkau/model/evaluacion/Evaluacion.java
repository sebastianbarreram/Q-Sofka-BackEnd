package co.com.qsofkau.model.evaluacion;
import co.com.qsofkau.model.aspirante.Aspirante;
import co.com.qsofkau.model.pregunta.Pregunta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Evaluacion {
    private String id;
    private List<Pregunta> preguntaList1;
    private List<Pregunta> preguntaList2;

    public Evaluacion(List<Pregunta> preguntaList) {
        Collections.shuffle(preguntaList);
        this.preguntaList1 = preguntaList.subList(0,1);
        this.preguntaList2 = preguntaList.subList(1,2);
    }
}
