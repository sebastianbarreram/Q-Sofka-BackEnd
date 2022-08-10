package co.com.qsofkau.mongo.evaluacion;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface EvaluacionMongoDBRepository extends ReactiveMongoRepository<EvaluacionDocument, String>, ReactiveQueryByExampleExecutor<EvaluacionDocument> {
}
