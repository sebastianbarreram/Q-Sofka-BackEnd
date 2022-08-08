package co.com.qsofkau.mongo.pregunta;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface PreguntaMongoDBRepository extends ReactiveMongoRepository<PreguntaDocument, String>, ReactiveQueryByExampleExecutor<PreguntaDocument> {
}
