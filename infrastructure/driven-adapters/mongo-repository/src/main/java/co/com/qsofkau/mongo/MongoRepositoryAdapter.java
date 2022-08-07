/*package co.com.qsofkau.mongo;

import co.com.qsofkau.model.pregunta.Pregunta;
import co.com.qsofkau.model.pregunta.gateways.PreguntaRepository;
import co.com.qsofkau.mongo.helper.AdapterOperations;
import co.com.qsofkau.mongo.pregunta.PreguntaDocument;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<Pregunta, PreguntaDocument, String, MongoDBRepository>
 implements PreguntaRepository
{

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {

        super(repository, mapper, d -> mapper.map(d, Pregunta.class));
    }
}*/
