package co.com.qsofkau.mongo.pregunta;

import co.com.qsofkau.model.pregunta.Pregunta;
import co.com.qsofkau.model.pregunta.gateways.PreguntaRepository;
import co.com.qsofkau.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;

public class PreguntaMongoRepositoryAdapter extends AdapterOperations<Pregunta, PreguntaDocument, String, PreguntaMongoDBRepository>
implements PreguntaRepository
{

    public PreguntaMongoRepositoryAdapter(PreguntaMongoDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Pregunta.class));
    }
}
