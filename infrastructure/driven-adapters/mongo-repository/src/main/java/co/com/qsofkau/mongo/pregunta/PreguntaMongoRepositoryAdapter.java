package co.com.qsofkau.mongo.pregunta;

import co.com.qsofkau.model.pregunta.Pregunta;
import co.com.qsofkau.model.pregunta.gateways.PreguntaRepository;
import co.com.qsofkau.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PreguntaMongoRepositoryAdapter extends AdapterOperations<Pregunta, PreguntaDocument, String, PreguntaMongoDBRepository>
implements PreguntaRepository
{

    public PreguntaMongoRepositoryAdapter(PreguntaMongoDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Pregunta.class));
    }

    @Override
    public Flux<Pregunta> findByCoachId(String id) {
        return this.repository
                .findAll()
                .filter(preguntaDocument -> preguntaDocument.getCoachId().equals(id))
                .map(d -> mapper.map(d, Pregunta.class));

    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);


    }
}
