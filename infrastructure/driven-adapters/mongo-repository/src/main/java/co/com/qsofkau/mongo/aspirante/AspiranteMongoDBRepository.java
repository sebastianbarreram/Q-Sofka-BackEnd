package co.com.qsofkau.mongo.aspirante;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface AspiranteMongoDBRepository extends ReactiveMongoRepository<AspiranteDocument, String>, ReactiveQueryByExampleExecutor<AspiranteDocument> {
}
