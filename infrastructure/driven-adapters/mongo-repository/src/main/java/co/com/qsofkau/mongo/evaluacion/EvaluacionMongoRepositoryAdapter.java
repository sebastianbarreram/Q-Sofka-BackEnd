package co.com.qsofkau.mongo.evaluacion;

import co.com.qsofkau.model.evaluacion.Evaluacion;
import co.com.qsofkau.model.evaluacion.gateways.EvaluacionRepository;
import co.com.qsofkau.model.pregunta.Pregunta;
import co.com.qsofkau.model.pregunta.gateways.PreguntaRepository;
import co.com.qsofkau.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class EvaluacionMongoRepositoryAdapter extends AdapterOperations<Evaluacion, EvaluacionDocument, String, EvaluacionMongoDBRepository>
implements EvaluacionRepository
{

    public EvaluacionMongoRepositoryAdapter(EvaluacionMongoDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Evaluacion.class));
    }


}
