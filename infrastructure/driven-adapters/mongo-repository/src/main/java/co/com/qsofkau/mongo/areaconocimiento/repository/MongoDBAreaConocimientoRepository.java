package co.com.qsofkau.mongo.areaconocimiento.repository;

import co.com.qsofkau.mongo.areaconocimiento.document.AreaConocimientoDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBAreaConocimientoRepository extends ReactiveMongoRepository<AreaConocimientoDocument, String>, ReactiveQueryByExampleExecutor<AreaConocimientoDocument> {
}
